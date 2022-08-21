package com.ksnk.numbers.ui.detailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ksnk.numbers.R
import com.ksnk.numbers.utils.changeFragment
import com.ksnk.numbers.data.entity.NumbersEntity
import com.ksnk.numbers.ui.homeFragment.HomeFragment

class DetailFragment : Fragment() {

    private var backImageButton: ImageButton? = null
    private var numberTextView: TextView? = null
    private var fullInfoTextView: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        setListeners()
        loadAndSetArguments()
    }

    private fun loadAndSetArguments() {
        val number = arguments?.getSerializable("number") as NumbersEntity
        fullInfoTextView?.text = number.text
        numberTextView?.text = number.number
    }

    private fun init(view: View) {
        backImageButton = view.findViewById(R.id.imageButtonBack)
        fullInfoTextView = view.findViewById(R.id.textViewDetailFullInfo)
        numberTextView = view.findViewById(R.id.textViewDetailNumber)
    }

    private fun setListeners() {
        backImageButton?.setOnClickListener {
            val homeFragment = HomeFragment().newInstance()
            changeFragment(homeFragment)
        }
    }

    companion object

    fun newInstance(): DetailFragment {
        return DetailFragment()
    }
}