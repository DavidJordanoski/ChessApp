package com.fict.chesspuzzle

import com.github.bhlangonijr.chesslib.File
import com.github.bhlangonijr.chesslib.Rank
import com.github.bhlangonijr.chesslib.Square


interface ChessDelegate {
    fun pieceAt(square: Square) : ChessPieceLocation?
    fun moveFigure(from: Square, to: Square)
}