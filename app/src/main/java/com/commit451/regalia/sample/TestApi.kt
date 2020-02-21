package com.commit451.regalia.sample

import com.commit451.regalia.sample.adapter.TestModel
import com.commit451.regalia.sample.adapter.TestModel2
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by hristijan on 8/26/19 to long live and prosper !
 */
interface TestApi {


    @GET("posts")
    suspend fun getPosts() : Response<List<TestModel>>

    @GET("employees")
    suspend fun getPosts2(): Response<TestModel2>

    companion object {
        const val API = "https://jsonplaceholder.typicode.com/"
        const val API2 = "http://dummy.restapiexample.com/api/v1/"
    }
}