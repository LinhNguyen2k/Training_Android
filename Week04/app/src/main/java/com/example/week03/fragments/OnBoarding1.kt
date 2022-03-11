package com.example.week03.fragments

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week03.view.Account_Activity
import com.example.week03.R
import kotlinx.android.synthetic.main.fragment_on_boarding1.view.*


class OnBoarding1 : Fragment() {
    lateinit var sharedPreferences: SharedPreferences
    var check : Boolean = false
    override fun onAttach(context: Context) {
        CheckSkip()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_boarding1, container, false)

        view.tv_nextBoarding1.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding12_to_onBoarding223)
        }

        view.tv_skip.setOnClickListener {
            sharedPreferences = requireActivity().getSharedPreferences("SAVE_CHECK", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("check", true)
            editor.apply()
            activity?.startActivity(Intent(activity, Account_Activity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }

        return view
    }

    fun CheckSkip() {
        sharedPreferences = requireActivity().getSharedPreferences("SAVE_CHECK", MODE_PRIVATE)
        check = sharedPreferences.getBoolean("check", false)
        if (check) {
            activity?.startActivity(Intent(activity, Account_Activity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }
    }

    override fun onDetach() {
        if (check){
            super.onDetach()
        }
    }

}