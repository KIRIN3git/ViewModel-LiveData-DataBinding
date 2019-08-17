package kirin3.jp.viewmodel_livedata_databinding

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kirin3.jp.viewmodel_livedata_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // インスタンスを発行
        val viewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        // Bindingオブジェクトを生成する（onCreateの外でもよい）
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // viewModelを設定
        binding.viewModel = viewModel
        // ライフサイクル所有者を設定
        binding.lifecycleOwner = this
    }
}
