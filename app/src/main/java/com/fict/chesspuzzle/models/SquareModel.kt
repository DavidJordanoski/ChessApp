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
  var figureType: String, //this square contains figure of type: p r n b q k, P R N B Q K, or "" for empty
  //small letters black, capital letters white
  var isSelectedFrom: Boolean, //this square is selected as 'from'. It is indication that we will move the figure
  // from here
  var isSelectedTo: Boolean,//this square is selected as 'to'. It is indication for the destination of the figure
  var isValidMove: Boolean, //this square is valid move
  var isLightSquare: Boolean //white/black background of the square
) {

  fun emptyField() = figureType != "."
  fun isWhiteRook() = figureType == "R"
  fun isBlackRook() = figureType == "r"
  fun isWhiteKing() = figureType == "K"
  fun isBlackKing() = figureType == "k"
  fun isWhitePawn() = figureType == "P"
  fun isBlackPawn() = figureType == "p"
  fun isWhiteQueen() = figureType == "Q"
  fun isBlackQueen() = figureType == "q"
  fun isWhiteKnight() = figureType == "N"
  fun isBlackKnight() = figureType == "n"
  fun isWhiteBishop() = figureType == "B"
  fun isBlackBishop()  = figureType == "b"


}
