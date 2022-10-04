package com.fict.chesspuzzle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.File
import com.github.bhlangonijr.chesslib.Rank
import com.github.bhlangonijr.chesslib.Square
import old.TAG
import kotlin.math.min

class Board(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var originX = 40f
    private var originY = 250f
    private var cellSide = 170f
    private val scaleFactor = .9f
    private val paint = Paint ()

    override fun onDraw(canvas: Canvas?) {

        Log.d(TAG, "${canvas?.width}, ${canvas?.height}")
        canvas?.let {
            val chessBoardSide = min(it.width, it.height) * scaleFactor
            cellSide = chessBoardSide / 8f
            originX = (it.width - chessBoardSide) / 2f
            originY = (it.height - chessBoardSide) / 2f
        }

        drawChessBoard(canvas)

    }

    private  fun drawChessBoard (canvas: Canvas?) {
        var board = Board();

        for (row in 0..7) {
            for (col in 0..7) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(resources.getColor(R.color.green2));
                canvas?.drawRect(
                    (originX - 0.35 * cellSide).toFloat(),
                    (originY - 0.35 * cellSide).toFloat(),
                    (originX + 8.35 * cellSide).toFloat(),
                    (originY + 8.35 * cellSide).toFloat(), paint);
            }
        }

        for (rank in 0..7) {
            var r = Rank.allRanks[rank];
            for(file in 0..7) {
                var f = File.allFiles[file]
                if(!File.NONE.equals(f) && !Rank.NONE.equals(r)) {
                    var sq = Square.encode(r,f);
                    var piece = board.getPiece(sq);

                    if(sq.isLightSquare) {
                        paint.color = resources.getColor(R.color.creamy)
                    } else {
                        paint.color = resources.getColor(R.color.green)
                    }

                    canvas?.drawRect(originX + rank * cellSide, originY + file * cellSide,
                        originX + (rank+1) * cellSide, originY + (file+1) * cellSide, paint)
                }
            }
        }

        for (row in 0..7) {
            for (col in 0..7) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.BLACK);
                canvas?.drawRect(
                    (originX - 0 * cellSide).toFloat(),
                    (originY - 0 * cellSide).toFloat(),
                    (originX + 8 * cellSide).toFloat(),
                    (originY + 8 * cellSide).toFloat(), paint);
            }
        }


        for (row in 0..7) {
            for (col in 0..7) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.BLACK);
                canvas?.drawRect(
                    (originX - 0.35 * cellSide).toFloat(),
                    (originY - 0.35 * cellSide).toFloat(),
                    (originX + 8.35 * cellSide).toFloat(),
                    (originY + 8.35 * cellSide).toFloat(), paint
                )
            }
        }
    }

}