package com.marlena.pictures_context_project.dataSource

import com.marlena.pictures_context_project.core.App

abstract class DataSource() {

    private var page = 1
    private var nextPage = -1
    private var totalPage = 1

    fun loadInitial(){
        App.movieRepository.getMovieList(page)
        nextPage = page + 1
    }

    fun loadAfter(page: Int){

    }


}
//    private var lastPage = false
//    private var page = 0
//
//    var onScrollListener = object : RecyclerView.OnScrollListener() {
//        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//            super.onScrollStateChanged(recyclerView, newState)
//
//            if (!lastPage && !recyclerView.canScrollVertically(1)) {
//                requestNextPage()
//            }
//        }
//    }
//
//    abstract fun showProgressBar()
//    abstract fun hideProgressBar()
//    abstract fun requestListData()
//
//    fun requestNextPage() {
//        showProgressBar()
//        lastPage = false
//
//        requestListData()
//        page++
//    }
//
//    fun endPagination() {
//        page = 0
//        lastPage = true
//        hideProgressBar()
//    }
//}