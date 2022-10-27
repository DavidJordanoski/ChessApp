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
        val isLightSquare = x % 2 == y % 2
        val s = SquareModel(x, y, "", false, false, false, isLightSquare)
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

  fun get(x: Int, y: Int): SquareModel { //todo add checks for index out of bounds
    return squares.get(y * 8 + x)
  }

  fun get(index: Int): SquareModel { //todo add checks for index out of bounds
    return squares.get(index)
  }

  fun add(squareModel: SquareModel) {
    squares.add(squareModel)
  }

  //todo give better naming to the methods below

  fun isSomeFieldSelectedAsFrom(): Boolean {
    for (i in 0..(squares.size - 1)) {
      if (squares.get(i).isSelectedFrom) {
        return true
      }
    }
    return false
  }

  fun isSomeFieldSelectedAsTo(): Boolean {
    for (i in 0..(squares.size - 1)) {
      if (squares.get(i).isSelectedTo) {
        return true
      }
    }
    return false
  }

  fun deselectAll() {
    for (i in 0..(squares.size - 1)) {
      squares.get(i).isSelectedFrom = false
      squares.get(i).isSelectedTo = false
    }
  }

  //todo
  fun getSelectedFromX(): Int {
    for (x in 0..7) {
      for (y in 0..7) {
        if (squares.get(y * 8 + x).isSelectedFrom) {
          return x
        }
      }
    }
    return -1 //ili exeption ili null zavisi kakva implementacija ke sakate
  }
}