package com.fict.chesspuzzle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), ChessDelegate {

    private var chessModel = ChessModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<BoardView>(R.id.board_view).chessDelegate = this

    }

    override fun pieceAt(square: Square): ChessPiece? = ChessModel.pieceAt(square)

    override fun moveFigure(from: Square, to: Square) {
        chessModel.moveFigure(from,to)
        findViewById<BoardView>(R.id.board_view).invalidate()
    }
}

