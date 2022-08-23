package com.fict.chesspuzzle

class ChessModel {
    var piecesBox = mutableSetOf<ChessPiece>()

    init {
        piecesBox.add(ChessPiece(0, 0, ChessPlayer.WHITE, ChessFigure.ROOK ))
        piecesBox.add(ChessPiece(0,7, ChessPlayer.BLACK, ChessFigure.ROOK))
        piecesBox.add(ChessPiece(0,6, ChessPlayer.BLACK, ChessFigure.PAWN))
    }

    fun pieceAt(col: Int, row: Int) : ChessPiece? {
        for (piece in piecesBox) {
            if (col == piece.col && row == piece.row){
                return piece
            }
        }
        return null
    }

    override fun toString(): String {
        var desc = " \n"
        for (row in 7 downTo 0){
            desc += "$row"
            for (col in 0..7){
                val piece = pieceAt(col, row)
                if (piece == null) {
                    desc += " ."
                } else {
                    val white = piece.player == ChessPlayer.WHITE
                    desc += ""
                    desc += when (piece.figure) {
                        ChessFigure.KING -> {
                            if (white) " wK" else " bK"
                        }
                        ChessFigure.QUEEN -> {
                            if (white) " wQ" else " bQ"
                        }
                        ChessFigure.BISHOP -> {
                            if (white) " wB" else " bB"
                        }
                        ChessFigure.KNIGHT -> {
                            if (white) " wN" else " bN"
                        }
                        ChessFigure.ROOK -> {
                            if (white) " wR" else " bR"
                        }
                        ChessFigure.PAWN -> {
                            if (white) " wP" else " bP"
                        }

                    }
                }
            }
            desc += "\n"
        }
        desc += " 0 1 2 3 4 5 6 7"

        return desc
    }
}