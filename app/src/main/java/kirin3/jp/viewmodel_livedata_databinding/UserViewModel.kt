package kirin3.jp.viewmodel_livedata_databinding

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    // LiveViewを作成
    val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
    // 初期値を0に設定
    init{
        user.value = User("Suzuki Ichiro",55)
    }

}