package com.fict.chesspuzzle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bhlangonijr.chesslib.*
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Piece
import old.BoardView
import old.ChessDelegate
import old.ChessModel
import old.ChessPiece
import old.Position

class BoardActivity : AppCompatActivity(), com.fict.chesspuzzle.ChessDelegate {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chess_board_activity)

        findViewById<com.fict.chesspuzzle.Board>(R.id.board_view).chessDelegate = this


      //  val string = intent.getStringExtra("fen")
        //board.loadFromFen(string)
        //board.setPiece(Piece.WHITE_KING,Square.A1)
        //for (squares in Square.values()){
          //  val piece = board.getPiece(squares)
            //println(piece)
        //}



    }

    override fun pieceAt(file: File, rank: Rank): AddPieces? = com.fict.chesspuzzle.ChessModel.pieceAt(file,rank)
}