package com.ksnk.numbers.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.AndroidViewModel
import com.ksnk.numbers.R


fun Fragment.changeFragment(fragment: Fragment) {
    val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
    transaction.replace(R.id.fragmentContainerViewMain, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}

fun AndroidViewModel.showToast(text: String) {
    Toast.makeText(getApplication(), text, Toast.LENGTH_SHORT).show()
}