package com.fict.chesspuzzle.models

import android.R.array





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



  //  fun isWhite(x: Int, y :Int) {
  //      getItemAt is capital letter or small?
  //  }

  //  fun isEmpty(x: Int, y :Int) {
  // ""   "x"
  //  }

  //tuka ke bidi i  conversion of "a8" vo (0,0)

  fun get(x: Int, y: Int): SquareModel { //todo add checks for index out of bounds
    if(checkForIndexOutOfBounds(y * 8 + x)){
      return squares[y * 8 + x]
    }
    return getInitSquareModel()
  }

  fun get(index: Int): SquareModel { //todo add checks for index out of bounds
    if(checkForIndexOutOfBounds(index)){
      return squares[index]
    }
    return getInitSquareModel()
  }



  private fun checkForIndexOutOfBounds(index: Int): Boolean{
    return (index >= 0 && index < squares.size)
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
        if (squares[y * 8 + x].isSelectedFrom) {
          return x
        }
      }
    }
    return -1 //ili exeption ili null zavisi kakva implementacija ke sakate
  }

  fun isWhiteRook(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteRook()
  }

  fun isBlackRook(x: Int, y: Int) : Boolean {
    return get(x,y).isBlackRook()
  }

  fun isWhiteKnight(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteKnight()
  }

  fun isBlackKnight(x: Int, y: Int) : Boolean {
    return get(x,y).isBlackKnight()
  }

  fun isWhiteBishop(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteBishop()
  }

  fun isBlackBishop(x: Int, y: Int) : Boolean {
    return get(x,y).isBlackBishop()
  }

  fun isWhiteQueen(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteQueen()
  }

  fun isBlackQueen(x: Int, y: Int) : Boolean {
    return get(x,y).isBlackQueen()
  }

  fun isWhiteKing(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteKing()
  }

  fun isBlackKing(x: Int, y: Int) : Boolean {
    return get(x,y).isBlackKing()
  }

  fun isWhitePawn(x: Int, y: Int) : Boolean {
    return get(x,y).isWhitePawn()
  }
  fun isBlackPawn(x: Int, y: Int) : Boolean {
    return get(x,y).isBlackPawn()
  }

  fun isRook(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteRook() || get(x,y).isBlackRook()
  }

  fun isKnight(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteKnight() || get(x,y).isBlackKnight()
  }

  fun isBishop(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteBishop() || get(x,y).isBlackBishop()
  }

  fun isQueen(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteQueen() || get(x,y).isBlackQueen()
  }

  fun isKing(x: Int, y: Int) : Boolean {
    return get(x,y).isWhiteKing() || get(x,y).isBlackKing()
  }

  fun isPawn(x: Int, y: Int) : Boolean {
    return get(x,y).isWhitePawn() || get(x,y).isBlackPawn()
  }





  fun getInitSquareModel() : SquareModel {
    return SquareModel(0,0,"",false,false,false,false)
  }
}