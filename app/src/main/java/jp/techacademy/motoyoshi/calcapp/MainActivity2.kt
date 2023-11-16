package jp.techacademy.motoyoshi.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.motoyoshi.calcapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val num3 = intent.getStringExtra("num3")
        binding.textView.text = num3.toString()
    }
}



