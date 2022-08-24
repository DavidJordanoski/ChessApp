package com.fict.chesspuzzle

class ChessModel {
    var piecesBox = mutableSetOf<ChessPiece>()

    init {
        reset()
    }

    fun reset() {
        piecesBox.removeAll(piecesBox)
        for (i in 0..1) {
            piecesBox.add(ChessPiece(0+i*7,0, ChessPlayer.WHITE, ChessFigure.ROOK, R.drawable.white_rook))
            piecesBox.add(ChessPiece(0+i*7,7, ChessPlayer.BLACK, ChessFigure.ROOK, R.drawable.black_rook))

            piecesBox.add(ChessPiece(1+i*5,0, ChessPlayer.WHITE, ChessFigure.KNIGHT, R.drawable.white_knight))
            piecesBox.add(ChessPiece(1+i*5,7, ChessPlayer.BLACK, ChessFigure.KNIGHT, R.drawable.black_knight))

            piecesBox.add(ChessPiece(2+i*3,0, ChessPlayer.WHITE, ChessFigure.BISHOP, R.drawable.white_bishop))
            piecesBox.add(ChessPiece(2+i*3,7, ChessPlayer.BLACK, ChessFigure.BISHOP, R.drawable.black_bishop))

        }

        for (i in 0..7) {
            piecesBox.add(ChessPiece(i,1, ChessPlayer.WHITE, ChessFigure.PAWN, R.drawable.white_pawn))
            piecesBox.add(ChessPiece(i,6, ChessPlayer.BLACK, ChessFigure.PAWN, R.drawable.black_pawn))
        }

        piecesBox.add(ChessPiece(3,0, ChessPlayer.WHITE, ChessFigure.QUEEN, R.drawable.white_queen))
        piecesBox.add(ChessPiece(3,7, ChessPlayer.BLACK, ChessFigure.QUEEN, R.drawable.black_queen))
        piecesBox.add(ChessPiece(4,0, ChessPlayer.WHITE, ChessFigure.KING, R.drawable.white_king))
        piecesBox.add(ChessPiece(4,7, ChessPlayer.BLACK ,ChessFigure.KING, R.drawable.black_king))

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