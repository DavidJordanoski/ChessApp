package com.fict.chesspuzzle.models


/**
 * Pure business logic of our model.
 */
open class BoardModel { //8x8 = 64

  // 0 1 2 3 4 5 6 7
  // 8 9 10...
  // .... .. .. .63

  // 0 1 2 3.......... 63

  private val squares: MutableList<SquareModel> = mutableListOf() //8x8

  init {
    for (y in 0..7) {
      for (x in 0..7) {
        val s = SquareModel(x, y, "", false, false)
        val isLightSquare = x % 2 == y % 2
        squares.add(s)
      }
    }
  }


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
    squares.add(squareModel)
  }
}