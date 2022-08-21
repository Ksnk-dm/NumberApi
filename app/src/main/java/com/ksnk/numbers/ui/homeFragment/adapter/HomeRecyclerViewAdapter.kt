package com.ksnk.numbers.ui.homeFragment.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ksnk.numbers.R
import com.ksnk.numbers.utils.changeFragment
import com.ksnk.numbers.data.entity.NumbersEntity
import com.ksnk.numbers.ui.detailFragment.DetailFragment


class HomeRecyclerViewAdapter(private val numbersList: List<NumbersEntity>, fragment: Fragment) :
    RecyclerView.Adapter<HomeViewHolder>() {

    private var fragment: Fragment? = null

    init {
        this.fragment = fragment
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.numberTextView.text = numbersList[position].number
        holder.titleTextView.text = numbersList[position].text
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("number", numbersList[position])
            val detailFragment = DetailFragment().newInstance()
            detailFragment.arguments = bundle
            fragment?.changeFragment(detailFragment)

        }
    }

    override fun getItemCount(): Int = numbersList.size
}