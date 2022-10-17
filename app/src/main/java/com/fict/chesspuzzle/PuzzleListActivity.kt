package com.fict.chesspuzzle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fict.chesspuzzle.compose.BoardComposeActivity
import com.fict.chesspuzzle.models.PuzzleModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PuzzleListActivity : AppCompatActivity(), PuzzleListAdapter.ClickListener {
  private lateinit var recyclerView: RecyclerView
  private lateinit var puzzleListAdapter: PuzzleListAdapter
  var puzzleList: List<PuzzleModel> = java.util.ArrayList<PuzzleModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.puzzles_activity)
    recyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(this)
    puzzleListAdapter = PuzzleListAdapter(this)
    recyclerView.adapter = puzzleListAdapter

    //fetchPuzzles()
    puzzleListAdapter.setData(getMockPuzzles())
  }

  private fun fetchPuzzles(): List<PuzzleModel> {
    puzzleList = java.util.ArrayList<PuzzleModel>()
    val apiService: Api = RetrofitClient().getRetrofitClient()
    val call: Call<List<PuzzleModel>> = apiService.getPuzzles()
    call.enqueue(object : Callback<List<PuzzleModel>> {
      override fun onResponse(
        call: Call<List<PuzzleModel>>,
        response: Response<List<PuzzleModel>>
      ) {
        puzzleList = response.body() as List<PuzzleModel>
        Log.d("TAG", "Response = $puzzleList")
        puzzleListAdapter.setData(puzzleList)
      }

      override fun onFailure(call: Call<List<PuzzleModel>>, t: Throwable) {
        Log.d("TAG", "Response = $t")
      }
    })
    return puzzleList
  }

  private fun getMockPuzzles(): List<PuzzleModel> {
    val puzzlesList = ArrayList<PuzzleModel>()

    val suffix = " b KQkq e3 0 1"
    //b/w - side to move
    //KQ - caste king and queen side
    //K - king side
    //Q - queen side
    //with lower case for the black side, capital for the white side

    puzzlesList.add(PuzzleModel("5bnr/ppp/8/8/8/8/8/6NR", "Chess Title 100"))
    puzzlesList.add(PuzzleModel("8/1p1p1p/8/8/8/8/8/8", "Chess Title 101"))

    puzzlesList.add(
      PuzzleModel(
        "1nb1kbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR b KQkq e3 0 1",
        "Chess Title 1"
      )
    )
    puzzlesList.add(PuzzleModel("2bqkbnr/1ppppppp/p7/8/8/8/PPPPPPPP/RNBQKBNR", "Chess Title 2"))
    puzzlesList.add(PuzzleModel("1nbqkbnr/1pppp1pp/p7/8/8/8/PPPPPPPP/RNBQKBNR", "Chess Title 3"))
    puzzlesList.add(PuzzleModel("rnbqkbnr/ppppp1pp/8/8/8/8/PPPPPPPP/RNBQKBNR", "Chess Title 4"))

    return puzzlesList
  }

  override fun clickedItem(puzzleModel: PuzzleModel) {
    //val intent = Intent(this, BoardActivity::class.java)
    val intent = Intent(this, BoardComposeActivity::class.java)
    intent.putExtra("fen", puzzleModel.fen)
    startActivity(intent)
  }
}

