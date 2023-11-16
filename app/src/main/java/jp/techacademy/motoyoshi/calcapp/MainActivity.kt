package jp.techacademy.motoyoshi.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
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

        //未入力チェック　
        //エディットテキスト1と2のどちらかがNullなら
        if(binding.editText1.getText().toString().equals("") == true || binding.editText2.getText().toString().equals("") == true) {
            showAlertDialog()



        }else{
            //押した釦の種類での条件分岐
            val intent = Intent(this, MainActivity2::class.java)
            var num1: Double = binding.editText1.text.toString().toDouble()
            var num2: Double = binding.editText2.text.toString().toDouble()
            //プラス(button1)を押したとき
            if(v.id == R.id.button1) {
                var num3 = num1 + num2
                intent.putExtra("num3", num3.toString())
            }
            //マイナス(button2)
            if(v.id == R.id.button2) {
                var num3 = num1 - num2
                intent.putExtra("num3", num3.toString())
            }
            //掛け算(button3)
            if(v.id == R.id.button3) {
                var num3 = num1 * num2
                intent.putExtra("num3", num3.toString())
            }
            //割り算(button4)
            if(v.id == R.id.button4) {
                var num3 = num1 / num2
                intent.putExtra("num3", num3.toString())
            }

            //画面遷移の実行
            startActivity(intent)

        }

    }

    //エラー表示
    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("エラー")
        alertDialogBuilder.setMessage("入力欄をすべて埋めてからボタンを押してください")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK"){dialog, which ->
        }
        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}




