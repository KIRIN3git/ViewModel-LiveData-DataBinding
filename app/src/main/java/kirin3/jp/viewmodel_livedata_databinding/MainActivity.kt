package kirin3.jp.viewmodel_livedata_databinding

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // アクティビティに属するカウンター
        var counterA = 0

        // 何度も使いまわされるインスタンスを作成
        val viewModel: CountViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        val text1 = findViewById(R.id.text1) as TextView
        val text2 = findViewById(R.id.text2) as TextView

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            counterA++
            text1.setText(counterA.toString())

            // ViewModelの監視対象のメンバ変数を+1
            viewModel.counterB.value = viewModel.counterB.value!! + 1
        }

        // UI更新用のオブザーバーを作成
        val countObserver = Observer<Int> { counter ->
            // TextViewを更新
            text2.text = counter.toString()
        }

        // LiveDataを観察し、このアクティビティをLifecycleOwnerおよびオブザーバーとして渡す
        viewModel.counterB.observe(this, countObserver)


    }
}
