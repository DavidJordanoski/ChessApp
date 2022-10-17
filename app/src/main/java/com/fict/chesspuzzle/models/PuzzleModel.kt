package com.fict.chesspuzzle.models

import com.google.gson.annotations.SerializedName

data class PuzzleModel(
    @SerializedName("id") var fen: String,
    @SerializedName("title") var description: String
)