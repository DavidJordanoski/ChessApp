package com.fict.chesspuzzle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PuzzleListActivity : AppCompatActivity(), PuzzleListAdapter.ClickListener {
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

    private fun addPuzzles():List<PuzzleModel> {
        var puzzlesList = ArrayList<PuzzleModel>()
        puzzlesList.add(PuzzleModel( "1nb1kbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR","Chess Title 1"))
        puzzlesList.add(PuzzleModel( "2bqkbnr/1ppppppp/p7/8/8/8/PPPPPPPP/RNBQKBNR","Chess Title 2"))
        puzzlesList.add(PuzzleModel( "1nbqkbnr/1pppp1pp/p7/8/8/8/PPPPPPPP/RNBQKBNR","Chess Title 3"))
        puzzlesList.add(PuzzleModel( "rnbqkbnr/ppppp1pp/8/8/8/8/PPPPPPPP/RNBQKBNR","Chess Title 4"))

        return puzzlesList
    }

    private fun showData(){
        puzzleListAdapter.setData(addPuzzles())
    }

    override fun clickedItem(puzzleModel: PuzzleModel) {
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("fen", puzzleModel.fen)
        startActivity(intent)
    }
}

