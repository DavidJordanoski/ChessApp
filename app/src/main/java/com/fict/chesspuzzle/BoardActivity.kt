package com.fict.chesspuzzle

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fict.chesspuzzle.Model.board
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Piece
import com.github.bhlangonijr.chesslib.Square
import com.github.bhlangonijr.chesslib.move.Move

class BoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chess_board_activity)
        findViewById<BoardView>(R.id.board_view)
        val string = intent.getStringExtra("fen")
        board.loadFromFen(string)
        board.setPiece(Piece.WHITE_KING,Square.A1)
        for (squares in Square.values()){
            val piece = board.getPiece(squares)
            println(piece)
        }

        print(board)
    }
}