package com.mkrdeveloper.movieinfoappmvvm.viewModel

import com.mkrdeveloper.movieinfoappmvvm.models.Details
import com.mkrdeveloper.movieinfoappmvvm.models.MoviesList
import com.mkrdeveloper.movieinfoappmvvm.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMovieList(page:Int): Response<MoviesList>{
        return RetrofitInstance.api.getMovies(page)
    }
    suspend fun getDetailsById(id:Int): Response<Details>{
        return RetrofitInstance.api.getDetailsById(id = id)
    }
}