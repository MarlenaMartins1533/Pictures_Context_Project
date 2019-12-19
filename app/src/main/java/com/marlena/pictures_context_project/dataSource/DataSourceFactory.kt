package com.marlena.pictures_context_project.dataSource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.marlena.pictures_context_project.model.response.CatResponse

class DataSourceFactory : DataSource.Factory<Int, CatResponse>() {

    private var dataSource: CatDataSource? = null
    private var mutableLiveData: MutableLiveData<CatDataSource>? = null

    override fun create(): DataSource<Int, CatResponse> {
        dataSource = CatDataSource()
        mutableLiveData?.postValue(dataSource)
        return dataSource as CatDataSource
    }
}