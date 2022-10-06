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
                return  piece
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
        for (i in 0 until 2) {
            addPiece(AddPieces(File.FILE_E, Rank.RANK_4, R.drawable.white_rook))
            addPiece(AddPieces(File.FILE_A, Rank.RANK_8, R.drawable.black_rook))


   /*         addPiece(ChessPiece(1 + i * 5, 0, Player.WHITE, Chessman.KNIGHT, R.drawable.knight_white))
            addPiece(ChessPiece(1 + i * 5, 7, Player.BLACK, Chessman.KNIGHT, R.drawable.knight_black))

            addPiece(ChessPiece(2 + i * 3, 0, Player.WHITE, Chessman.BISHOP, R.drawable.bishop_white))
            addPiece(ChessPiece(2 + i * 3, 7, Player.BLACK, Chessman.BISHOP, R.drawable.bishop_black))
        }

        for (i in 0 until 8) {
            addPiece(ChessPiece(i, 1, Player.WHITE, Chessman.PAWN, R.drawable.pawn_white))
            addPiece(ChessPiece(i, 6, Player.BLACK, Chessman.PAWN, R.drawable.pawn_black))
        }

        addPiece(ChessPiece(3, 0, Player.WHITE, Chessman.QUEEN, R.drawable.queen_white))
        addPiece(ChessPiece(3, 7, Player.BLACK, Chessman.QUEEN, R.drawable.queen_black))
        addPiece(ChessPiece(4, 0, Player.WHITE, Chessman.KING, R.drawable.king_white))
        addPiece(ChessPiece(4, 7, Player.BLACK, Chessman.KING, R.drawable.king_black))
    }*/

}
    }
}