package com.fict.chesspuzzle

import android.view.View
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import kotlin.math.min

class BoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private final var originX = 40f
    private final var originY = 250f
    private final var cellSide = 170f
    private final val scaleFactor = .9f
    private final val paint = Paint ()
    private var fromCol: Int = -1
    private var fromRow: Int = -1
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

    var chessDelegate: ChessDelegate? = null

    init {
        loadBitmaps()
    }

    override fun onDraw(canvas: Canvas?) {

        Log.d(TAG, "${canvas?.width}, ${canvas?.height}")
        canvas?.let {
            val chessBoardSide = min(it.width, it.height) * scaleFactor
            cellSide = chessBoardSide / 8f
            originX = (it.width - chessBoardSide) / 2f
            originY = (it.height - chessBoardSide) / 2f
        }

        drawChessBoard(canvas)
        drawPieces(canvas)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return false
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                fromCol = ((event.x - originX) / cellSide).toInt()
                fromRow = 7 - ((event.y - originY) / cellSide).toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                //               Log.d(TAG, "move")
            }
            MotionEvent.ACTION_UP -> {
                val col = ((event.x - originX) / cellSide).toInt()
                val row = 7 - ((event.y - originY) / cellSide).toInt()
                Log.d(TAG, "from ($fromCol, $fromRow) to ($col, $row)")
                chessDelegate?.moveFigure(fromCol, fromRow, col, row)
            }
        }
        return true
    }

    private fun drawPieces(canvas: Canvas?){
        for (row in 0..7) {
            for (col in 0..7) {
                val piece = chessDelegate?.pieceAt(col, row)
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