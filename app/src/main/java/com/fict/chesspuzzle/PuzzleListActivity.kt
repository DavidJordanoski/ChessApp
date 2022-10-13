package com.fict.chesspuzzle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fict.chesspuzzle.models.PuzzleModel

class PuzzleListActivity : AppCompatActivity(), PuzzleListAdapter.ClickListener {
  private lateinit var recyclerView: RecyclerView
  private lateinit var puzzleListAdapter: PuzzleListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.puzzles_activity)
    recyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(this)
    puzzleListAdapter = PuzzleListAdapter(this)
    recyclerView.adapter = puzzleListAdapter

    fetchPuzzles();
  }

  private fun fetchPuzzles() { //todo setup retrofit to get data from backend
    puzzleListAdapter.setData(getMockPuzzles())
  }

  private fun getMockPuzzles(): List<PuzzleModel> {
    var puzzlesList = ArrayList<PuzzleModel>()

    val suffix = " b KQkq e3 0 1"
    //b/w - side to move
    //KQ - caste king and queen side
    //K - king side
    //Q - queen side
    //with lower case for the black side, capital for the white side

    puzzlesList.add(PuzzleModel("5bnr/ppp/8/8/8/8/8/6NR", "Chess Title 100"))
    puzzlesList.add(PuzzleModel("8/1p1p1p/8/8/8/8/8/8", "Chess Title 101"))

    puzzlesList.add(PuzzleModel("1nb1kbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", "Chess Title 1"))
    puzzlesList.add(PuzzleModel("2bqkbnr/1ppppppp/p7/8/8/8/PPPPPPPP/RNBQKBNR", "Chess Title 2"))
    puzzlesList.add(PuzzleModel("1nbqkbnr/1pppp1pp/p7/8/8/8/PPPPPPPP/RNBQKBNR", "Chess Title 3"))
    puzzlesList.add(PuzzleModel("rnbqkbnr/ppppp1pp/8/8/8/8/PPPPPPPP/RNBQKBNR", "Chess Title 4"))

    return puzzlesList
  }

  override fun clickedItem(puzzleModel: PuzzleModel) {
    val intent = Intent(this, BoardActivity::class.java)
    intent.putExtra("fen", puzzleModel.fen)
    startActivity(intent)
  }
}

