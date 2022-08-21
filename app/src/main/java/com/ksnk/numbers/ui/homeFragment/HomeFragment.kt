package com.ksnk.numbers.ui.homeFragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ksnk.numbers.R
import com.ksnk.numbers.data.entity.NumbersEntity
import com.ksnk.numbers.ui.homeFragment.adapter.HomeRecyclerViewAdapter

class HomeFragment : Fragment() {
    private var mActivityViewModel: HomeViewModel? = null
    private var searchEditText: EditText? = null
    private var searchButtonImageButton: ImageButton? = null
    private var randomImageButton: ImageButton? = null
    private var mRecyclerView: RecyclerView? = null
    private lateinit var mNumbersList: MutableList<NumbersEntity>
    private lateinit var mAdapter: HomeRecyclerViewAdapter
    private var mGridLayoutManager: GridLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        initRecycler()
        setListeners()
        setObserveRecycler()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivityViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private fun setObserveRecycler() {
        mActivityViewModel?.getAll()?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                updateUI(it)
            }
        })
    }

    private fun setListeners() {
        searchButtonImageButton?.setOnClickListener {
            if (!searchEditText?.text.isNullOrEmpty()) {
                mActivityViewModel?.retroFitResponseSearch(searchEditText?.text.toString())
            }
        }

        randomImageButton?.setOnClickListener {
            mActivityViewModel?.getRandomNumber()
        }
    }

    private fun init(view: View) {
        searchEditText = view.findViewById(R.id.editTextSearch)
        searchButtonImageButton = view.findViewById(R.id.imageButtonSearch)
        randomImageButton = view.findViewById(R.id.imageButtonRandom)
        mRecyclerView = view.findViewById(R.id.recyclerViewMain)
    }

    private fun initRecycler() {
        mNumbersList = ArrayList()
        mGridLayoutManager = GridLayoutManager(activity, 1)
        mAdapter = HomeRecyclerViewAdapter(mNumbersList, this)
        mRecyclerView?.adapter = mAdapter
        mRecyclerView?.layoutManager = mGridLayoutManager
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun updateUI(it: List<NumbersEntity>) {
        if (it.isNotEmpty()) {
            mNumbersList.clear()
            mNumbersList.addAll(it.reversed())
            mAdapter.notifyDataSetChanged()
        } else {
            mNumbersList.clear()
            mAdapter.notifyDataSetChanged()
        }
    }

    companion object

    fun newInstance(): HomeFragment {
        return HomeFragment()
    }
}