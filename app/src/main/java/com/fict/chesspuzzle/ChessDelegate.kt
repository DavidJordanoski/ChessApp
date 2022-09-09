package com.fict.chesspuzzle

interface ChessDelegate {
    fun pieceAt(position: Position) : ChessPiece?
    fun moveFigure(from: Position, to: Position)
}