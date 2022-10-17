package com.fict.chesspuzzle

import com.fict.chesspuzzle.models.PuzzleModel
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("todos/")
    fun getPuzzles(): Call<List<PuzzleModel>>

    @POST("")
    fun createPuzzles(@Body puzzle: PuzzleModel): Call<Void?>?

    @DELETE("")
    fun deletePuzzles(@Path("id") id: Int): Call<Void?>?

}