package com.example.nguyenanhlinh_exercise_thread

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.currentThread
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mHandler = Handler(Looper.getMainLooper())
    private var check: Boolean = false
    private var number = 0
    var v1 = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTextColor()
        btn_addition.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        btn_addition.setBackgroundColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.green
                            )
                        )
                        stopThread()
                        mHandler.postDelayed(runnable, 100)

                    }
                    MotionEvent.ACTION_UP -> {
                        btn_addition.setBackgroundColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.teal_200
                            )
                        )
                        mHandler.removeCallbacks(runnable)
                        startThread()
                    }
                }
                return true
            }

            var runnable: Runnable = object : Runnable {
                override fun run() {
                    tv_result.text = (tv_result.text.toString().toInt() + 1).toString()
                    mHandler.postDelayed(this, 100)
                }

            }

        })

        btn_subtraction.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        btn_subtraction.setBackgroundColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.green
                            )
                        )
                        stopThread()
                        mHandler.postDelayed(runnable, 100)

                    }
                    MotionEvent.ACTION_UP -> {
                        btn_subtraction.setBackgroundColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.teal_200
                            )
                        )
                        mHandler.removeCallbacks(runnable)
                        startThread()
                    }
                }
                return true
            }

            var runnable: Runnable = object : Runnable {
                override fun run() {
                    tv_result.text = (tv_result.text.toString().toInt() - 1).toString()
                    mHandler.postDelayed(this, 100)
                }

            }

        })

        layout_LinearLayout.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        stopThread()
                        v1 = event.y.toInt()
                    }
                    MotionEvent.ACTION_MOVE -> {
                        if (event.y.toInt() > v1)
                            tv_result.text = (tv_result.text.toString().toInt() - 1).toString()
                        else if (event.y.toInt() < v1)
                            tv_result.text = (tv_result.text.toString().toInt() + 1).toString()
                    }
                    MotionEvent.ACTION_UP -> {
                        startThread()
                        return true
                    }
                }
                return true
            }
        })
        initHandler()

    }

    private var thread = Thread()
    private var runnable = Runnable {
        number = tv_result.text.toString().toInt()
        while (check && number != 0) {
            if (number > 0) {
                number--
            } else
                number++
            val msg = Message()
            msg.what = MESSAGE
            msg.arg1 = number
            mHandler.sendMessage(msg)
            sleep()
        }

    }

    companion object {
        const val MESSAGE = 1000
    }

    private fun initHandler() {
        mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    MESSAGE -> tv_result!!.text = msg.arg1.toString()
                }
            }
        }
    }

    private fun sleep() {
        try {
            Thread.sleep(50)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }


    private fun randomColor() {
        val rd = Random()
        val color: Int =
            Color.argb(
                255,
                rd.nextInt(256),
                rd.nextInt(256), rd.nextInt(256)
            )
        tv_result.setTextColor(color)
    }

    private fun setTextColor() {
        Thread {
            while (true) {
                val count = tv_result.text.toString().toInt()
                if (count != 0) {
                    try {
                        Thread.sleep(3000)
                        mHandler.post { randomColor()
                        }
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }.start()
    }


    private fun startThread() {
        synchronized(this) { check = true }
        thread = Thread(runnable)
        mHandler.postDelayed({ thread.start() }, 2000)
    }

    private fun stopThread() {
        synchronized(this) { check = false }
        mHandler.removeCallbacksAndMessages(null)
        currentThread().interrupt()
        if (!thread.isInterrupted) {
            thread.interrupt()
        }
    }

}

