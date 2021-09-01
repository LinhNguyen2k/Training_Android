package com.example.week03.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.week03.R
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUp : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)


        view.tv_forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_email)
        }

        view.tv_login.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_login)
        }

        return view
    }
}