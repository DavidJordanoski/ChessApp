package com.fict.chesspuzzle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), ChessDelegate {

    private var chessModel = ChessModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chess_board_activity)

        findViewById<BoardView>(R.id.board_view).chessDelegate = this

    }

    override fun pieceAt(position: Position): ChessPiece? = ChessModel.pieceAt(position)

    override fun moveFigure(from: Position, to: Position) {
        chessModel.moveFigure(from,to)
        findViewById<BoardView>(R.id.board_view).invalidate()
    }
}

