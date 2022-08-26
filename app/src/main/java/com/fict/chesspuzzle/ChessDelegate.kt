package com.fict.chesspuzzle

interface ChessDelegate {
    fun pieceAt(col: Int, row: Int) : ChessPiece?
    fun moveFigure(fromCol: Int, formRow: Int, toCol: Int, toRow: Int)
}