package com.fict.chesspuzzle

interface ChessDelegate {
    fun pieceAt(col: Int, row: Int) : ChessPiece?
}