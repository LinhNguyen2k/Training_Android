package com.example.week03.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.week03.Account_Activity
import com.example.week03.R
import kotlinx.android.synthetic.main.fragment_on_boarding3.view.*
import kotlinx.android.synthetic.main.fragment_on_boarding3.view.tv_skip

class OnBoarding3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding3, container, false)

        view.view_backOnboarding3.setOnClickListener {
            findNavController().navigateUp()
        }
        view.tv_skip.setOnClickListener {
            val intent = Intent(activity, Account_Activity::class.java)
            activity?.startActivity(intent)

        }

        return view
    }


}