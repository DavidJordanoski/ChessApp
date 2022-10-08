package com.fict.chesspuzzle

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.bhlangonijr.chesslib.*
import com.github.bhlangonijr.chesslib.Piece
import com.github.bhlangonijr.chesslib.move.Move

class BoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chess_board_activity)
        var boardView = BoardView(this,attrs = null)
        findViewById<BoardView>(R.id.board_view)
        val board = Board()
        val string = intent.getStringExtra("fen")
      /*  board.loadFromFen(string)
        board.setPiece(Piece.WHITE_KING,Square.A1)
        for (squares in Square.values()){
            val piece = board.getPiece(squares)
            println(piece)
        }*/

        boardView.board.doMove(Move(Square.B1,Square.B4))
        print(boardView)
    }

}