package kirin3.jp.viewmodel_livedata_databinding

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    // LiveViewを作成
    val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
    // 初期値を設定
    init{
        user.value = User("SUZUKI",45)
    }
    // ボタンクリック時の値を変更する関数
    fun change(){
        user.value = User("OHTANI",25)
    }

    // LiveDataの更新を他のLiveDataの更新に依存させる
    val logo: LiveData<LogoMark> = Transformations.map(user) {
        when {
            user.value!!.age > 40 -> LogoMark.LOGO1
            else -> LogoMark.LOGO2
        }
    }
}

enum class LogoMark {
    LOGO1,
    LOGO2
}

