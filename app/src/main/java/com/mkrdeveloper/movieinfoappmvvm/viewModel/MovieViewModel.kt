package com.mkrdeveloper.movieinfoappmvvm.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkrdeveloper.movieinfoappmvvm.models.Data
import com.mkrdeveloper.movieinfoappmvvm.models.Details
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState())
    var id by mutableIntStateOf(0)

    init {
        viewModelScope.launch {
            val response = repository.getMovieList(state.page)
            state = state.copy(
                movies = response.body()!!.data
            )
        }
    }

    fun getDetailsById() {
        viewModelScope.launch {
            try {
                val response = repository.getDetailsById(id = id)
                if (response.isSuccessful) {
                    state = state.copy(
                        detailsData = response.body()!!
                    )
                }
            } catch (e: Exception) {

            }
        }
    }
}

data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1,
    val detailsData: Details = Details()
)