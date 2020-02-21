package com.commit451.regalia.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.commit451.regalia.sample.adapter.Data
import com.commit451.regalia.sample.adapter.TestModel
import com.crazylegend.kotlinextensions.log.debug


/**
 * Created by crazy on 2/21/20 to long live and prosper !
 */
class TestParcelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getParcelableExtra<Data>("test")
        val item2 = intent.getParcelableArrayListExtra<Data>("test2")
        debug("TEST MODEL $item")

        debug("TEST LIST MODEL $item2")
    }
}