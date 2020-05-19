package com.commit451.regalia.sample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.commit451.regalia.gson.realmGsonConverterFactory
import com.commit451.regalia.moshi.RegaliaMoshi
import com.commit451.regalia.sample.adapter.TestModel
import com.commit451.regalia.sample.adapter.TestModel2
import com.crazylegend.kotlinextensions.coroutines.makeApiCallLiveData
import com.crazylegend.kotlinextensions.retrofit.RetrofitClient
import com.crazylegend.kotlinextensions.retrofit.RetrofitResult
import retrofit2.create


/**
 * Created by hristijan on 8/26/19 to long live and prosper !
 */

/**
 * Template created by Hristijan to live long and prosper.
 */

class TestAVM(application: Application) : AndroidViewModel(application) {

    private val postsData: MediatorLiveData<RetrofitResult<TestModel2>> = MediatorLiveData()
    val posts: LiveData<RetrofitResult<TestModel2>> = postsData


    fun getposts() {
        makeApiCallLiveData(postsData) { retrofit2?.getPosts2() }
    }

    init {
        getposts()
    }


    private val retrofit2 by lazy {
        RetrofitClient.customInstance(context = application, baseUrl = TestApi.API2, enableInterceptor = true){
            addConverterFactory(RegaliaMoshi.moshiConverterFactory)
            this
        }?.create<TestApi>()
    }


    private val retrofit by lazy {
        RetrofitClient.customInstance(context = application, baseUrl = TestApi.API2, enableInterceptor = true){
            addConverterFactory(realmGsonConverterFactory(TestModel::class.java))
            this
        }?.create<TestApi>()
    }


}



