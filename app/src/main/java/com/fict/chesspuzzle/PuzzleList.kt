package com.fict.chesspuzzle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fict.chesspuzzle.model.PuzzleListModel

class PuzzleList : AppCompatActivity() {
    private lateinit var newPuzzlesList: ArrayList<PuzzleListModel>
    private lateinit var newRecyclerView: RecyclerView
    lateinit var Title : Array<String>
    lateinit var FEN : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puzzles_activity)


        Title = arrayOf(
            "Chess Puzzle 1",
            "Chess Puzzle 2",
            "Chess Puzzle 3",
            "Chess Puzzle 4",
            "Chess Puzzle 5",
            "Chess Puzzle 6",
            "Chess Puzzle 7",
            "Chess Puzzle 8",
            "Chess Puzzle 9",
            "TChess Puzzle 10"
        )

        FEN = arrayOf(
            "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",
            "4R3/8/8/2Pkp3/N7/4rnKB/1nb5/b1r5",
            "1k6/1P5Q/8/7B/8/5K2/8/8",
            "8/8/7N/3p2pk/3p2p1/3P4/P1K5/8",
            "8/1P5B/8/2P5/8/6K1/NkP3p1/RN6",
            "8/8/5b2/8/8/5pk1/8/2BQK2R",
            "2K5/1B3N2/8/5R2/3k4/8/7B/4r3",
            "8/8/8/4R1n1/7N/3K4/3p4/4N2k",
            "8/1P6/8/8/3p4/1p1k4/3ppK2/8",
            "8/3Q4/8/1p3N2/2k5/8/2N5/6K1",
        )

        newRecyclerView = findViewById(R.id.RecyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newPuzzlesList = arrayListOf<PuzzleListModel>()
        getUserData()
    }

    private fun getUserData() {
        for(i in Title.indices){
            val puzzleList = PuzzleListModel(Title[i], FEN[i])
            newPuzzlesList.add(puzzleList)
        }

        newRecyclerView.adapter = PuzzleListAdapter(newPuzzlesList)
    }

}

