package com.fict.chesspuzzle

import android.view.View
import android.content.Context
import android.graphics.*
import android.util.AttributeSet

class BoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private final val originX = 40f
    private final val originY = 250f
    private final val cellSide = 170f
    private final val paint = Paint ()
    private final val imgResourceIDs = setOf(
        R.drawable.black_bishop,
        R.drawable.black_king,
        R.drawable.black_knight,
        R.drawable.black_pawn,
        R.drawable.black_queen,
        R.drawable.black_rook,
        R.drawable.white_bishop,
        R.drawable.white_king,
        R.drawable.white_knight,
        R.drawable.white_pawn,
        R.drawable.white_queen,
        R.drawable.white_rook,
    )

    private final val bitmaps = mutableMapOf<Int, Bitmap>()

    init {
        loadBitmaps()
    }

    override fun onDraw(canvas: Canvas?) {
        drawChessBoard(canvas)
        drawPieces(canvas)

    }

    private fun drawPieces(canvas: Canvas?){
        val chessModel = ChessModel()
        chessModel.reset()

        for (row in 0..7) {
            for (col in 0..7) {
                val piece = chessModel.pieceAt(col, row)
                if (piece != null) {
                    drawPieceAt(canvas, col, row, piece.resourceID)
                }
            }
        }
    }

    private fun drawPieceAt(canvas: Canvas?, col: Int, row: Int, resID: Int) {
        val bitmap = bitmaps[resID]!!
        canvas?.drawBitmap(bitmap, null, RectF (originX + col * cellSide, originY + (7-row) * cellSide, originX +(col+1) * cellSide, originY + ((7-row)+1) * cellSide), paint)
    }

    private fun loadBitmaps() {
        imgResourceIDs.forEach {
            bitmaps[it] = BitmapFactory.decodeResource(resources, it)
        }
    }
    private  fun drawChessBoard (canvas: Canvas?) {
        for (row in 0..7) {
            for (col in 0..7) {
                paint.color = if ((row + col) % 2 == 1) Color.DKGRAY else Color.LTGRAY
                canvas?.drawRect(originX + row * cellSide, originY + col * cellSide, originX + (row+1) * cellSide, originY + (col+1) * cellSide, paint)
            }
        }

    }
}