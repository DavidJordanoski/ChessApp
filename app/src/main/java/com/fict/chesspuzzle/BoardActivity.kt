package com.fict.chesspuzzle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fict.chesspuzzle.Model.board
import com.github.bhlangonijr.chesslib.Square

class BoardActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.chess_board_activity)
    val fen = intent.getStringExtra("fen")
    board.loadFromFen("$fen w")
    for (squares in Square.values()) {
      val piece = board.getPiece(squares)
    }
    val boardPositions = BoardPositions()
    boardPositions.FromSquareToCoordinate(Square.A5)
    boardPositions.FromCoordinateToSquare(1,1)
  }

}