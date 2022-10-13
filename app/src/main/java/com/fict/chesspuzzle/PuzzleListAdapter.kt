package com.fict.chesspuzzle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fict.chesspuzzle.models.PuzzleModel


class PuzzleListAdapter(clickListener: ClickListener) : RecyclerView.Adapter<PuzzleListAdapter.MyViewHolder>() {

  private var puzzlesList: List<PuzzleModel> = arrayListOf()
  private lateinit var context: Context
  private var clickListener: ClickListener = clickListener

  fun setData(puzzleModel: List<PuzzleModel>) {
    this.puzzlesList = puzzleModel
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    context = parent.context
    return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.puzzle_details_activity, parent, false))
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    var puzzleListModel = puzzlesList.get(position)
    var description = puzzleListModel.description
    var fen = puzzleListModel.fen

    holder.description.text = description
    holder.fen.text = fen

    holder.itemView.setOnClickListener {
      clickListener.clickedItem(puzzleListModel)
    }
  }

  override fun getItemCount(): Int {
    return puzzlesList.size
  }

  interface ClickListener {
    fun clickedItem(puzzleModel: PuzzleModel)
  }

  class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val description = itemView.findViewById<TextView>(R.id.descriptionTextView)
    val fen = itemView.findViewById<TextView>(R.id.fenTextView)
  }

}