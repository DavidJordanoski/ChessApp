package com.fict.chesspuzzle

import com.github.bhlangonijr.chesslib.File
import com.github.bhlangonijr.chesslib.Rank
import com.github.bhlangonijr.chesslib.Square


interface ChessDelegate {
    fun pieceAt(file: File,rank: Rank) : AddPieces?
}