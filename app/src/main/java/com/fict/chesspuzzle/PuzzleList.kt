package com.fict.chesspuzzle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PuzzleList : AppCompatActivity(), PuzzleListAdapter.ClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var puzzleListAdapter: PuzzleListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puzzles_activity)
        initData();

    }
    private fun initData(){
        recyclerView = findViewById(R.id.RecyclerView)
        initRecyclerView();
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        puzzleListAdapter = PuzzleListAdapter(this);
        recyclerView.adapter = puzzleListAdapter;
        showData();
    }

    private fun addPuzzles():List<PuzzleListModel> {
        var puzzlesList = ArrayList<PuzzleListModel>()
        puzzlesList.add(PuzzleListModel("Chess Title 1", "1nb1kbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"))
        puzzlesList.add(PuzzleListModel("Chess Title 2", "2bqkbnr/1ppppppp/p7/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"))
        puzzlesList.add(PuzzleListModel("Chess Title 3", "1nbqkbnr/1pppp1pp/p7/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"))
        puzzlesList.add(PuzzleListModel("Chess Title 4", "rnbqkbnr/ppppp1pp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"))
        puzzlesList.add(PuzzleListModel("Chess Title 5", "FEN 5"))
        puzzlesList.add(PuzzleListModel("Chess Title 6", "FEN 6"))
        puzzlesList.add(PuzzleListModel("Chess Title 7", "FEN 7"))
        puzzlesList.add(PuzzleListModel("Chess Title 8", "FEN 8"))

        return puzzlesList
    }

    private fun showData(){
        puzzleListAdapter.setData(addPuzzles())
    }

    override fun clickedItem(puzzleListModel: PuzzleListModel) {
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("fen", puzzleListModel.puzzleFen)
        startActivity(intent)
    }


}

