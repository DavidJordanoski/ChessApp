package com.fict.chesspuzzle

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.github.bhlangonijr.chesslib.*
import com.github.bhlangonijr.chesslib.move.Move
import old.TAG
import kotlin.math.min

class Board(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val board = Board()
    private var originX = 40f
    private var originY = 250f
    private var cellSide = 170f
    private val scaleFactor = .9f
    private val paint = Paint ()
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
    private val bitmaps = mutableMapOf<Int, Bitmap>()

    var chessDelegate: com.fict.chesspuzzle.ChessDelegate? = null
    init {
        loadBitmaps()
    }

    private fun loadBitmaps() {
        imgResourceIDs.forEach{
            bitmaps[it] = BitmapFactory.decodeResource(resources,it)
        }
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

    private fun drawPieces(canvas: Canvas?) {
        drawPieceAt(canvas, File.FILE_D, Rank.RANK_1, R.drawable.white_queen,Piece.WHITE_QUEEN)
    }

    /*private fun drawPieces(canvas: Canvas?) {
        for (rank in 0..7) {
            var r = Rank.allRanks[rank]
            for (file in 0..7) {
                var f = File.allFiles[file]

                chessDelegate?.pieceAt(f,r)?.let {
                        drawPieceAt(canvas,f , r, it.resourceID)

                }
            }
        }
    }*/

    private fun drawPieceAt(canvas: Canvas?, file: File, rank: Rank,resID: Int,piece: Piece) {

        val bitmap = bitmaps[resID]!!

            when (piece.fenSymbol) {
                "Q" -> {R.drawable.white_queen}
                "N" -> {R.drawable.black_knight}
                else -> {}
            }

            println(board)


        canvas?.drawBitmap(bitmap, null, RectF (originX + file.ordinal * cellSide, originY + (7-rank.ordinal) * cellSide,
            originX +(file.ordinal+1) * cellSide, originY + ((7-rank.ordinal)+1) * cellSide), paint)
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