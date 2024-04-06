package com.mkrdeveloper.movieinfoappmvvm.paging

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}