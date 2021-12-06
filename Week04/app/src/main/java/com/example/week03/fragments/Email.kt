package com.example.week03.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.week03.R
import com.example.week03.sql.SQLite_Account
import com.example.week03.model.User
import kotlinx.android.synthetic.main.fragment_email.*
import kotlinx.android.synthetic.main.fragment_email.view.*

class Email : Fragment() {
    private var mHandler = Handler(Looper.getMainLooper())
    private val args by navArgs<EmailArgs>()

    lateinit var text: String
    var time = 5
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_email, container, false)
        val sqliteAccount = SQLite_Account(context)
        var email = args.setPassWord!!.email
        view.tv_resendEmail.setOnClickListener {
            sqliteAccount.updateData(email, "123")
            var user = User(email, "123")
            val action = EmailDirections.actionEmailToConfirmPassword(user)
            findNavController().navigate(action)
        }

        val thread = Thread {

            text = "Wait $time seconds before sending it"
            while (time != 0) {

                if (time > 0) {
                    time--
                    val msg = Message()
                    msg.what = MESSAGE
                    msg.arg1 = time
                    mHandler?.sendMessage(msg)
                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                } else if (time == 0)
                    view.tv_resendEmail.isEnabled = true
            }
        }
        thread.start()
        initHandler()

        return view
    }

    private fun initHandler() {
        mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    MESSAGE -> {
                        tv_countDown!!.text = "Wait ${msg.arg1} seconds before sending it"
                        if (msg.arg1 == 0) {
                            tv_resendEmail.isEnabled = true
                            tv_resendEmail.setBackgroundResource(R.drawable.custom_login_button)
                        }

                    }
                }
            }
        }
    }

    companion object {
        const val MESSAGE = 1000
    }

}