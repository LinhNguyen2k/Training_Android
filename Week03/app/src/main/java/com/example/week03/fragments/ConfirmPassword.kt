package com.example.week03.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.week03.R
import com.example.week03.sendDataAccount
import kotlinx.android.synthetic.main.fragment_confirm_password.view.*

class ConfirmPassword : Fragment(), sendDataAccount {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirm_password, container, false)

        view.tv_resendEmail.setOnClickListener {
            findNavController().navigate(R.id.action_confirmPassword_to_login)
        }
        return view
    }

    override fun sendData(editTextUserName: String, editTextPassWord: String) {
        val bundle = Bundle()
        bundle.putString("email",editTextUserName)
        bundle.putString("passWord",editTextPassWord)
    }
}