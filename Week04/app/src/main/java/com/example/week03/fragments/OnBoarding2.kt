package com.example.week03.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.week03.Account_Activity
import com.example.week03.R
import kotlinx.android.synthetic.main.fragment_on_boarding2.view.*
import kotlinx.android.synthetic.main.fragment_on_boarding2.view.tv_skip

class OnBoarding2 : Fragment() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding2, container, false)

        view.tv_nextBoarding2.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding22_to_onBoarding32)
        }
        view.view_backOnboarding2.setOnClickListener {
            findNavController().navigateUp()
        }

        view.tv_skip.setOnClickListener {
            sharedPreferences = requireActivity().getSharedPreferences("SAVE_CHECK",
                Context.MODE_PRIVATE
            )
            val editor = sharedPreferences.edit()
            editor.putBoolean("check",true)
            editor.apply()
            val intent = Intent(activity, Account_Activity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            activity?.startActivity(intent)

        }
        return view
    }
}