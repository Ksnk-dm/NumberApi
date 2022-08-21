package com.ksnk.numbers.ui.homeFragment.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ksnk.numbers.R


class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var numberTextView: TextView = itemView.findViewById(R.id.textViewNumber)
    var titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
}