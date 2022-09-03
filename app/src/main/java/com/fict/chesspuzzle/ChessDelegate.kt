package com.fict.chesspuzzle

interface ChessDelegate {
    fun pieceAt(square: Square) : ChessPiece?
    fun moveFigure(from: Square, to: Square)
}