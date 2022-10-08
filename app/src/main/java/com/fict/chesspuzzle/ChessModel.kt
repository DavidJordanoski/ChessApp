package com.fict.chesspuzzle

import android.content.ContentValues.TAG
import android.util.Log
import com.github.bhlangonijr.chesslib.*
import com.github.bhlangonijr.chesslib.Board


object ChessModel {
    val board = Board()
    var piecesBox = mutableSetOf<AddPieces>()

    init {
        reset()


        Log.d(TAG, toString())
        Log.d(TAG, " ${old.ChessModel.piecesBox.size}")
    }

    fun pieceAt(square: Square): AddPieces? {
        return pieceAt(square.file, square.rank)
    }

    fun pieceAt(file: File, rank: Rank): AddPieces? {
        for (piece in piecesBox) {
            if (file == piece.file && rank == piece.rank) {
                return piece
            }
        }
        return null
    }

    fun clear() {
        piecesBox.clear()
    }

    fun addPiece(pieces: AddPieces) {
        piecesBox.add(pieces)

    }

    fun reset() {
        clear()
        addPiece(AddPieces(File.FILE_A, Rank.RANK_1, R.drawable.white_rook))
        addPiece(AddPieces(File.FILE_B, Rank.RANK_1, R.drawable.white_knight))
        addPiece(AddPieces(File.FILE_C, Rank.RANK_1, R.drawable.white_bishop))
        addPiece(AddPieces(File.FILE_D, Rank.RANK_1, R.drawable.white_queen))
        addPiece(AddPieces(File.FILE_E, Rank.RANK_1, R.drawable.white_king))
        addPiece(AddPieces(File.FILE_F, Rank.RANK_1, R.drawable.white_bishop))
        addPiece(AddPieces(File.FILE_G, Rank.RANK_1, R.drawable.white_knight))
        addPiece(AddPieces(File.FILE_H, Rank.RANK_1, R.drawable.white_rook))

        addPiece(AddPieces(File.FILE_A, Rank.RANK_2,R.drawable.white_pawn))
        addPiece(AddPieces(File.FILE_B, Rank.RANK_2,R.drawable.white_pawn))
        addPiece(AddPieces(File.FILE_C, Rank.RANK_2,R.drawable.white_pawn))
        addPiece(AddPieces(File.FILE_D, Rank.RANK_2,R.drawable.white_pawn))
        addPiece(AddPieces(File.FILE_E, Rank.RANK_2,R.drawable.white_pawn))
        addPiece(AddPieces(File.FILE_F, Rank.RANK_2,R.drawable.white_pawn))
        addPiece(AddPieces(File.FILE_G, Rank.RANK_2,R.drawable.white_pawn))
        addPiece(AddPieces(File.FILE_H, Rank.RANK_2,R.drawable.white_pawn))

        addPiece(AddPieces(File.FILE_A, Rank.RANK_8, R.drawable.black_rook))
        addPiece(AddPieces(File.FILE_B, Rank.RANK_8, R.drawable.black_knight))
        addPiece(AddPieces(File.FILE_C, Rank.RANK_8, R.drawable.black_bishop))
        addPiece(AddPieces(File.FILE_D, Rank.RANK_8, R.drawable.black_queen))
        addPiece(AddPieces(File.FILE_E, Rank.RANK_8, R.drawable.black_king))
        addPiece(AddPieces(File.FILE_F, Rank.RANK_8, R.drawable.black_bishop))
        addPiece(AddPieces(File.FILE_G, Rank.RANK_8, R.drawable.black_knight))
        addPiece(AddPieces(File.FILE_H, Rank.RANK_8, R.drawable.black_rook))

        addPiece(AddPieces(File.FILE_A, Rank.RANK_7,R.drawable.black_pawn))
        addPiece(AddPieces(File.FILE_B, Rank.RANK_7,R.drawable.black_pawn))
        addPiece(AddPieces(File.FILE_C, Rank.RANK_7,R.drawable.black_pawn))
        addPiece(AddPieces(File.FILE_D, Rank.RANK_7,R.drawable.black_pawn))
        addPiece(AddPieces(File.FILE_E, Rank.RANK_7,R.drawable.black_pawn))
        addPiece(AddPieces(File.FILE_F, Rank.RANK_7,R.drawable.black_pawn))
        addPiece(AddPieces(File.FILE_G, Rank.RANK_7,R.drawable.black_pawn))
        addPiece(AddPieces(File.FILE_H, Rank.RANK_7,R.drawable.black_pawn))

    }
}

