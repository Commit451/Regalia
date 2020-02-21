package com.commit451.regalia.sample.adapter

import android.view.View
import com.commit451.regalia.sample.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import androidx.recyclerview.widget.RecyclerView

class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val card = itemView.testCard

    init {
        with(card.cardView) {
            setContentPadding(10, 10, 10, 10)
        }
    }

    fun bind(item: TestModel) {
        card.title = item.title
        card.content = item.body
        card.imageView.setImageResource(R.drawable.pin_code_highlight_state)
    }

    fun bind(item: Data) {
        card.title = item.employee_name
        card.content = item.employee_age
        card.imageView.setImageResource(R.drawable.pin_code_highlight_state)
    }
}