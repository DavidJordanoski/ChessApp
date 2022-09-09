package com.fict.chesspuzzle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fict.chesspuzzle.model.PuzzleListModel


class PuzzleListAdapter(private val puzzlesList: ArrayList<PuzzleListModel>) :
    RecyclerView.Adapter<PuzzleListAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val puzzleView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.puzzle_details_activity, parent, false)
        return MyViewHolder(puzzleView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPuzzle = puzzlesList[position]
        holder.title.text = currentPuzzle.puzzleTitle
        holder.fen.text = currentPuzzle.puzzleFen
    }
    override fun getItemCount(): Int {
        return puzzlesList.size
    }

    class MyViewHolder(puzzleView: View) : RecyclerView.ViewHolder(puzzleView) {

        val title: TextView = puzzleView.findViewById(R.id.puzzleTitle)
        val fen: TextView = puzzleView.findViewById(R.id.puzzleFEN)
    }


}