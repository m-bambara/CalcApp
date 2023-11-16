package jp.techacademy.motoyoshi.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import jp.techacademy.motoyoshi.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener { // 変更

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
    }

    // 以下の関数を追加
    override fun onClick(v: View) {

        //見入力ちぇく

        val intent = Intent(this, MainActivity2::class.java)
        var num1 : Double = binding.editText1.text.toString().toDouble()
        var num2 : Double = binding.editText2.text.toString().toDouble()

        //分岐
        var num3 : Double = num1 + num2

        intent.putExtra("num3",num3.toString())


        startActivity(intent)
    }
}


