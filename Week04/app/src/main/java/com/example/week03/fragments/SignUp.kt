package com.example.week03.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.week03.R
import com.example.week03.sql.SQLite_Account
import com.example.week03.model.User
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.edt_passWord
import kotlinx.android.synthetic.main.fragment_sign_up.view.tv_forgotPassword

class SignUp : Fragment() {

    private val sqLite_account = SQLite_Account(context)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        view.tv_forgotPassword.setOnClickListener {

            val email = view.edt_emmail.text.toString()
            val password = view.edt_passWord.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(
                    context,
                    "Bạn chưa nhập email",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            } else {
                if (!sqLite_account.checkEmail(email)) {
                    val use = User(email, password)
                    var account = SignUpDirections.actionSignUpToEmail(use)
                    findNavController().navigate(account)
                } else {
                    Toast.makeText(
                        context,
                        "Email chưa đúng",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
            }
        }

        view.tv_login.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_login)
        }

        view.btn_signUp.setOnClickListener {
            val email = view.edt_emmail.text.toString()
            val password = view.edt_passWord.text.toString()
            val use = User(email, password)

            if (email.isEmpty()) {
                Toast.makeText(context, "Tài khoản không được để trống.", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            } else if (password.isNotEmpty() && email.isNotEmpty()) {

                val db = SQLite_Account(context)
                val value: Long = db.addUser(email, password)
                Toast.makeText(context, "Đăng ký thành công.", Toast.LENGTH_LONG).show()
                val action = SignUpDirections.actionSignUpToLogin(use)
                findNavController().navigate(action)


            }

        }

        return view
    }
}