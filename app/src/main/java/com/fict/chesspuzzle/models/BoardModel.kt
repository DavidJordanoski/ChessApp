package com.fict.chesspuzzle.models

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.fict.chesspuzzle.R
import com.github.bhlangonijr.chesslib.*
import com.github.bhlangonijr.chesslib.move.Move
import com.github.bhlangonijr.chesslib.move.MoveGenerator


/**
 * Pure business logic of our model.
 */
open class BoardModel {
  val board = Board() //NO NO  NO get it out

  //8x8 = 64

  // 0 1 2 3 4 5 6 7
  // 8 9 10...
  // .... .. .. .63

  // 0 1 2 3.......... 63

  val figures: MutableList<SquareModel> = mutableListOf() //8x8 ova ke se polni od FEN

  //0-7 ili 1-8

//    fun getItemAt(x: Int, y :Int): String {
//      return "R" //"r"
//     y*8+x +
//     (y-1)*8+(x-1)
//    }

  //  fun isRook(x: Int, y :Int) {
  //use getItemAt
  //.equals(R or r) return true
  //  }

  //  fun isWhite(x: Int, y :Int) {
  //      getItemAt is capital letter or small?
  //  }

  //  fun isEmpty(x: Int, y :Int) {
  // ""   "x"
  //  }

  //tuka ke bidi i  conversion of "a8" vo (0,0)


  fun add(squareModel: SquareModel) {
    figures.add(squareModel)
  }
}