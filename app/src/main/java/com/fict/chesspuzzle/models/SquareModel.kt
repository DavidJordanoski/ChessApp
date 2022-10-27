package com.fict.chesspuzzle.models

/**
 * x - position on x axis.
 * y - position on y axis.
 * type - type of figure.
 */
class SquareModel(
  private val x: Int,
  private val y: Int,
  val type: String, // p r n b q k, P R N B Q K
  val isSelected: Boolean,
  val isValidMove: Boolean // will be set to true only if on the board something is already selected, and this field
  // is valid move
) {


  fun isEmpty(): Boolean {
    if (type.length > 0) {
      return false
    }
    return true
  }
}
//0,0,R 0,0,r

//field is valid move
//isValid move