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
import com.example.week03.R
import kotlinx.android.synthetic.main.fragment_email.*
import kotlinx.android.synthetic.main.fragment_email.view.*

class Email : Fragment() {
    private var mHandler = Handler(Looper.getMainLooper())
    lateinit var text: String
    var time = 5
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_email, container, false)


        view.tv_resendEmail.setOnClickListener {
            findNavController().navigate(R.id.action_email_to_confirmPassword)
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
        mHandler = object : Handler() {
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