package com.commit451.regalia.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.commit451.regalia.sample.adapter.TestAdapter
import com.crazylegend.kotlinextensions.activity.launchActivity
import com.crazylegend.kotlinextensions.context.getCompatColor
import com.crazylegend.kotlinextensions.delegates.activityVM
import com.crazylegend.kotlinextensions.exhaustive
import com.crazylegend.kotlinextensions.log.debug
import com.crazylegend.kotlinextensions.recyclerview.RecyclerSwipeItemHandler
import com.crazylegend.kotlinextensions.recyclerview.addSwipe
import com.crazylegend.kotlinextensions.recyclerview.clickListeners.forItemClickListenerDSL
import com.crazylegend.kotlinextensions.recyclerview.initRecyclerViewAdapter
import com.crazylegend.kotlinextensions.retrofit.RetrofitResult
import com.crazylegend.kotlinextensions.views.AppRater
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val testAVM by activityVM<TestAVM>()
    private val adapter by lazy {
        TestAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppRater.appLaunched(this, supportFragmentManager, 0, 0) {
            appTitle = getString(R.string.app_name)
            buttonsBGColor = getCompatColor(R.color.colorAccent)
        }

        recycler.initRecyclerViewAdapter(adapter)



        recycler.addSwipe(this) {
            swipeDirection = RecyclerSwipeItemHandler.SwipeDirs.BOTH
            drawableLeft = android.R.drawable.ic_delete
            drawLeftBackground = true
            leftBackgroundColor = R.color.colorPrimary
            drawableRight = android.R.drawable.ic_input_get
        }


        testAVM.posts.observe(this, Observer {
            it?.apply {
                when (it) {
                    is RetrofitResult.Success -> {
                        adapter.submitList(it.value.data)

                        adapter.forItemClickListener = forItemClickListenerDSL { position, item, _ ->
                            launchActivity<TestParcelActivity> {
                                putExtra("test", item)
                                putParcelableArrayListExtra("test2", ArrayList(it.value.data))
                            }
                        }

                        /*val wrappedList = it.value.toMutableList()
                        recycler.addDrag(adapter, wrappedList)*/

                    }
                    RetrofitResult.Loading -> {
                        debug(it.toString())
                    }
                    RetrofitResult.EmptyData -> {
                        debug(it.toString())
                    }
                    is RetrofitResult.Error -> {
                        debug(it.toString())
                    }
                    is RetrofitResult.ApiError -> {
                        debug(it.toString())
                    }
                }.exhaustive
            }
        })
    }

}
