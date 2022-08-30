package com.fict.chesspuzzle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), ChessDelegate {

    var chessModel = ChessModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<BoardView>(R.id.board_view).chessDelegate = this

    }

    override fun pieceAt(col: Int, row: Int): ChessPiece? {
        return chessModel.pieceAt(col, row)
    }

    override fun moveFigure(fromCol: Int, formRow: Int, toCol: Int, toRow: Int) {
        chessModel.moveFigure(fromCol, formRow, toCol, toRow)
        findViewById<BoardView>(R.id.board_view).invalidate()
    }
}

