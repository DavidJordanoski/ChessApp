package com.fict.chesspuzzle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Square

class BoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chess_board_activity)

        findViewById<com.fict.chesspuzzle.Board>(R.id.board_view).invalidate()

        val board = Board()
        val string = intent.getStringExtra("fen")
        board.loadFromFen(string)

        for (squares in Square.values()){
            val piece = board.getPiece(squares)
            println(piece)
        }


    }
}