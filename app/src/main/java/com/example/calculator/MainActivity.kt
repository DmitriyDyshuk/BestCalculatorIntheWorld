package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.Exception


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener { setTextField("0") }
        btn_1.setOnClickListener { setTextField("1") }
        btn_2.setOnClickListener { setTextField("2") }
        btn_3.setOnClickListener { setTextField("3") }
        btn_4.setOnClickListener { setTextField("4") }
        btn_5.setOnClickListener { setTextField("5") }
        btn_6.setOnClickListener { setTextField("6") }
        btn_7.setOnClickListener { setTextField("7") }
        btn_8.setOnClickListener { setTextField("8") }
        btn_9.setOnClickListener { setTextField("9") }
        btn_minus.setOnClickListener { setTextField("-") }
        btn_plus.setOnClickListener { setTextField("+") }
        btn_star.setOnClickListener { setTextField("*") }
        slash_btn.setOnClickListener { setTextField("/") }
        Leftskobka_btn.setOnClickListener { setTextField("(") }
        Rightskobka_btn.setOnClickListener { setTextField(")") }

        clear_btn.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }

        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                    math_operation.text = str.substring(0, str.length - 1)
            result_text.text = ""
        }

        btn_equal.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()

                result_text.text = if (result == longRes.toDouble()) longRes.toString() else result.toString()

            } catch (e:Exception) {
                Log.d("Ошибка", " сообщение: ${e.message}" )
            }
        }
    }

    private fun setTextField(str: String) {
        if (result_text.text.isNotEmpty()) {
            math_operation.text = result_text.text
            result_text.text = ""
        }

        math_operation.text = "${math_operation.text}$str"
    }

}