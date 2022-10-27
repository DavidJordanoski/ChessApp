package com.fict.chesspuzzle.models

/**
 *   x - this is x position on the board 0 on left 7 on right
 *   y - this is y position on the board 0 on top 7 on bottom
 *   figureType - this square contains figure of type: p r n b q k, P R N B Q K, or "" for empty
 *   isSelected - this square is selected
 *   isValidMove - this square is valid move
 */
class SquareModel(
  private val x: Int, //this is x position on the board 0 on left 7 on right
  private val y: Int, //this is y position on the board 0 on top 7 on bottom
  val figureType: String, //this square contains figure of type: p r n b q k, P R N B Q K, or "" for empty
  val isSelected: Boolean, //this square is selected
  val isValidMove: Boolean, //this square is valid move
  val isLightSquare: Boolean //white/black background of the square
) {

  fun isEmpty(): Boolean {
    return figureType.isEmpty()
  }
} //0,0,R 0,0,r

//field is valid move
//isValid move