package com.example.week03.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.week03.Account_Activity
import com.example.week03.Home_Activity
import com.example.week03.R
import com.example.week03.SQLite_Account
import com.example.week03.model.User
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.edt_passWord
import kotlinx.android.synthetic.main.fragment_login.view.tv_forgotPassword
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class Login : Fragment() {

    private val args by navArgs<LoginArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val sqLite_account = SQLite_Account(context)
        view.edt_email.setText(args.currentUsers?.email)
        view.edt_passWord.setText(args.currentUsers?.passWord)
        view.btn_login.setOnClickListener {

            val email = edt_email.text.toString()
            val password = edt_passWord.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            } else if (sqLite_account.chekUser(email, password)) {
                Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_LONG).show()
                val intent = Intent(activity, Home_Activity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            } else {
                Toast.makeText(
                    context,
                    "Tài khoản hoặc mật khẩu không chính xác",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
        }

        view.tv_forgotPassword.setOnClickListener {

//            if (!view.edt_email.text.toString().isEmpty()) {
//                val email = view.edt_email.text.toString().trim()
//                val password = view.edt_passWord.text.toString().trim()
//                if (!sqLite_account.checkEmail(email)) {
//                    val use = User(email, password)
//                    val action = LoginDirections.actionLoginToEmail(use)
//                    findNavController().navigate(action)
//                } else {
//                    Toast.makeText(context, "Email chưa tồn tại trong hệ thống !!!", Toast.LENGTH_LONG)
//                        .show()
//                }
//            } else {
//                Toast.makeText(context, "Bạn phải nhập email !!!", Toast.LENGTH_LONG).show()
//            }
            val email = view.edt_email.text.toString().trim()
            val password = view.edt_passWord.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(
                    context,
                    "Bạn chưa nhập email",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            } else {
                if (!sqLite_account.checkEmail(email)){
                    val use = User(email, password)
                    var account = LoginDirections.actionLoginToEmail(use)
                    findNavController().navigate(account)
                }else{
                    Toast.makeText(
                        context,
                        "Email chưa đúng",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
            }
        }

        view.tv_signUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signUp)
        }




        return view
    }
}


