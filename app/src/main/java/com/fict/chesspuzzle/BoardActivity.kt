package com.fict.chesspuzzle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fict.chesspuzzle.Model.board
import com.github.bhlangonijr.chesslib.Square

class BoardActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.chess_board_activity)

    //findViewById<BoardView>(R.id.board_view)

    val string = intent.getStringExtra("fen")
    board.loadFromFen(string)
    for (squares in Square.values()) {
      val piece = board.getPiece(squares)
      println(piece)
    }

    print(board)
  }

}