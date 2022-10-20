package com.fict.chesspuzzle.models

import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.File
import com.github.bhlangonijr.chesslib.Rank
import com.github.bhlangonijr.chesslib.Square

class SquareModel(private val x: Int, private val y :Int, val type: String) {

//    fun isSelected(x: Int,y: Int,selected: Boolean){
//        if (selected){
//            val col = File.allFiles[x]
//            val row = Rank.allRanks[y]
//            val sq = Square.encode(row, col)
//            val piece = board.getPiece(sq)
//            println(piece.fenSymbol)
//        }
//    }
}
//0,0,R 0,0,r

//isEmpty
//isSelected
//field is valid move
//isValid move