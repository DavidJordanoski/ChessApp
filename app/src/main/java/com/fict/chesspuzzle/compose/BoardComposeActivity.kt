package com.fict.chesspuzzle.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fict.chesspuzzle.R
import com.fict.chesspuzzle.models.BoardModel
import com.fict.chesspuzzle.models.SquareModel
import com.fict.chesspuzzle.usecase.LibraryLogic
import com.fict.myapplication.ui.theme.MyApplicationTheme
import com.github.bhlangonijr.chesslib.File
import com.github.bhlangonijr.chesslib.Rank
import com.github.bhlangonijr.chesslib.Square
import java.lang.StringBuilder
import java.util.*

//there should be no rules in this class
//only draw what is available in board model
open class BoardComposeActivity : ComponentActivity() {
    val boardLib = com.github.bhlangonijr.chesslib.Board()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RefreshableBoard(getInitBoardModel())
                }
            }
        }
    }
    fun getFenSymbol(x: Int,y: Int): String {
        val col = File.allFiles[x] //file is column, example A-File, H-File
        val row = Rank.allRanks[7-y] //rank is 1st to 8th rank
        val sq = Square.encode(row, col)
        val piece = boardLib.getPiece(sq)
        return piece.fenSymbol
    }

    fun getInitBoardModel(): BoardModel {
        //get FEN from intent
        val fen = intent.getStringExtra("fen")
        boardLib.loadFromFen(fen)
        //use the lib to create BoardModel
        val boardModel = BoardModel()
        val squares: MutableList<SquareModel> = mutableListOf()
        //for y 0 - 7
        //for x 0-7
        for (y in 0..7) {
            for (x in 0..7) {
                val isLightSquare = x % 2 == y % 2
                val s = SquareModel(x, y, getFenSymbol(x,y),
                    isSelectedFrom = false,
                    isSelectedTo = false,
                    isValidMove = false,
                    isLightSquare = isLightSquare
                )
                squares.add(s)
            }
        }
        //get proper peace and add it to the init model
        boardModel.setSquare(squares)
        return boardModel
    }
}

@Preview(device = Devices.DEFAULT, showSystemUi = true)
@Composable
fun RefreshableBoard(initBoardModel: BoardModel = BoardModel()) {
    var name by remember { mutableStateOf("") }

    var activeBoard by remember { mutableStateOf(initBoardModel) }

    Board(name = name, activeBoard, onNameChange = {
        name = it
    }, {
        activeBoard = it

        //ovde pak ja koristime bibliotekata za da setirame so noviot FEN
        //t.e da ja inicijalizirame bibliotekata so novata sostojba na tablata
        //taa sostojba e sodrzana vo 'it'

        //board.loadFromFen("new fen")
        //a toj new fen ke go zemite od 'it' sto e BoardModel i treba da go konvertirate vo FEN
        //ova se tie konverzii of FEN vo BoardModel i od BoardModel vo FEN

    })
}

@Composable
fun Board(
    name: String,
    board: BoardModel,
    onNameChange: (String) -> Unit,
    onBoardUpdate: (BoardModel) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(BorderStroke(width = 2.dp, color = Color.Black))
                .padding(2.dp)
        ) {
            for (y in 0..7) {
                Row {
                    for (x in 0..7) { //board.isLightSquare

                        //should be part of board-state
                        //var selected by remember { mutableStateOf(false) }

                        //one square item
                        Box(modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .border(
                                BorderStroke(
                                    width = 2.dp, color = getSelectionSquareColor(board, x, y)
                                )
                            )
                            .background(
                                getBackgroundSquareColor(
                                    board.get(
                                        x,
                                        y
                                    ).isLightSquare
                                )
                            )
                            .clickable { //selected = !selected //board.set(i,j - x,y) = selected
                                //board.setSelectedField(x,y)
                                //treba da se napraj pak trigger za valid fields preku usecase

                                if (board.isSomeFieldSelectedAsTo()) {
                                    board.deselectAll()
                                }

                                if (board.isSomeFieldSelectedAsFrom()) { //znaci odredeno pole e selektirano, sega treba da se napravi destination
                                    //toa sto e selectirano e from, ova novoto e destination
                                    board.get(x, y).isSelectedTo = !board.get(x, y).isSelectedTo

                                    //ovde e mrdanjeto na figurata
                                    //tuka treba da se napravi
                                    //prefrluvanje na vrednosta na board.get(fromX, fromY).figureType

                                    //vo board(toX, toY), sto prakticno ke bidat x i y (za to)
                                    //no za fromX, fromY treba da gi zemite za poleto sto ima isSelectedFrom
                                    //vidi getSelectedFromX
                                } else if (board.get(x,y).emptyField()) {
                                    board.get(x, y).isSelectedFrom = !board.get(x, y).isSelectedFrom
                                }



                                onBoardUpdate(board)
                                onNameChange("" + Date().time) //ugly hack
                            }) {
                            Text(text = "${x},${y}")

                            drawPieces(board = board, x = x, y = y)

                        }
                    }
                }
            } //ugly hack for refresh
            Column(modifier = Modifier.alpha(0f)) {
                OutlinedTextField(
                    value = "name",
                    onValueChange = onNameChange,
                    label = { Text("Name") })
            }
        }
    }
}

fun getSelectionSquareColor(board: BoardModel, x: Int, y: Int): Color {
    if (board.get(x, y).isSelectedFrom) {
        return Color.Red
    } else {
        if (board.get(x, y).isSelectedTo) {
            return Color.Green
        }
    }
    return Color.Transparent
}

fun getBackgroundSquareColor(isLightSquare: Boolean): Color {
    val darkSquare = Color(0xFF779556)
    val lightSquare = Color(0xFFEBECD0)
    return if (isLightSquare) lightSquare else darkSquare
}

@Composable
fun drawPieces(board: BoardModel,x: Int,y: Int){
    if (board.get(x, y).isWhiteRook()) {
        Image(
            painter = painterResource(id = R.drawable.white_rook),
            contentDescription = null
        )
    }
    if (board.get(x, y).isBlackRook()) {
        Image(
            painter = painterResource(id = R.drawable.black_rook),
            contentDescription = null
        )
    }
    if (board.get(x, y).isWhiteKnight()) {
        Image(
            painter = painterResource(id = R.drawable.white_knight),
            contentDescription = null
        )
    }
    if (board.get(x, y).isBlackKnight()) {
        Image(
            painter = painterResource(id = R.drawable.black_knight),
            contentDescription = null
        )
    }
    if (board.get(x, y).isWhiteBishop()) {
        Image(
            painter = painterResource(id = R.drawable.white_bishop),
            contentDescription = null
        )
    }
    if (board.get(x, y).isBlackBishop()) {
        Image(
            painter = painterResource(id = R.drawable.black_bishop),
            contentDescription = null
        )
    }
    if (board.get(x, y).isWhiteQueen()) {
        Image(
            painter = painterResource(id = R.drawable.white_queen),
            contentDescription = null
        )
    }
    if (board.get(x, y).isBlackQueen()) {
        Image(
            painter = painterResource(id = R.drawable.black_queen),
            contentDescription = null
        )
    }
    if (board.get(x, y).isWhiteKing()) {
        Image(
            painter = painterResource(id = R.drawable.white_king),
            contentDescription = null
        )
    }
    if (board.get(x, y).isBlackKing()) {
        Image(
            painter = painterResource(id = R.drawable.black_king),
            contentDescription = null
        )
    }
    if (board.get(x, y).isWhitePawn()) {
        Image(
            painter = painterResource(id = R.drawable.white_pawn),
            contentDescription = null
        )
    }
    if (board.get(x, y).isBlackPawn()) {
        Image(
            painter = painterResource(id = R.drawable.black_pawn),
            contentDescription = null
        )
    }
}

//check the state for the item at x,y for
//isEmpty
//isSelected
//field is valid move
//isValid move
//and draw it on the screen

//              if(board.getItem(x,y).isValidMove){
//                Image(
//                  painter = painterResource(id = R.drawable.valid_move), contentDescription = null
//                    )
//              }


//take the items from the model and draw tem
//if(white or black peace)
//              if(board.get(x,y).isRook()){
//                Image(
//                  painter = painterResource(id = R.drawable.white_rook), contentDescription = null
//                )
//              }