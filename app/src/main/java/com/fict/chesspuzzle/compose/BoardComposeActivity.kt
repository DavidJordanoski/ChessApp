package com.fict.chesspuzzle.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.util.rangeTo
import com.fict.chesspuzzle.R
import com.fict.chesspuzzle.models.BoardModel
import com.fict.chesspuzzle.models.SquareModel
import com.fict.myapplication.ui.theme.MyApplicationTheme
import com.github.bhlangonijr.chesslib.File
import com.github.bhlangonijr.chesslib.Rank
import com.github.bhlangonijr.chesslib.Square
import com.github.bhlangonijr.chesslib.move.Move

//there should be no rules in this class
//only draw what is available in board model
class BoardComposeActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) { //Board()
          //convert the FEN into our Board model
          Board()
        }
      }
    }
  }
}
@Preview(
  device = Devices.DEFAULT, showSystemUi = true
)
@Composable
fun Board(board: MutableState<BoardModel> = mutableStateOf(BoardModel())) {
  val boardFromLib = com.github.bhlangonijr.chesslib.Board()
  val squareModel: SquareModel
  val boardModel: BoardModel = BoardModel()
  val darkSquare = Color(0xFF779556)
  val lightSquare = Color(0xFFEBECD0)

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.LightGray)
  ) {

    //modifier = Modifier.padding(16.dp)
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .border(BorderStroke(width = 2.dp, color = Color.Black))
        .padding(2.dp)
    ) {
      for (j in 7 downTo 0) {
        Row {
          for (i in 0 until 8) {
            //board.isLightSquare
            val isLightSquare = j % 2 == i % 2
            val squareColor = if (isLightSquare) lightSquare else darkSquare

            //should be part of board-state
            var selected by remember { mutableStateOf(false) }

            //one square item
            Box(modifier = Modifier
              .weight(1f)
              .aspectRatio(1f)
              .border(
                BorderStroke(
                  width = 2.dp,
                  color = if (selected) Color.Red else Color.Transparent
                )
              )
              .background(squareColor)
              .clickable {
                selected = !selected
                //board.set(i,j - x,y) = selected
              }) {
              Text(text = "${i},${j}")
              //boardModel.fromSquareToCoordinate(Square.A5)
              boardModel.drawPieces(i, j)
              boardModel.isSelected(i,j,selected)
              //boardModel.getItemAt(1,1)
              //boardModel.isRook(7,7)
              //boardModel.isWhite(4,3) // not working
              //boardModel.isEmpty(0,1)

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
             }
            }
          }
        }
      }
    }
  }

