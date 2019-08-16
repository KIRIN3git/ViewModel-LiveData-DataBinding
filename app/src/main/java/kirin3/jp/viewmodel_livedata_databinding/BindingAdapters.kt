package kirin3.jp.viewmodel_livedata_databinding

import android.content.res.ColorStateList
import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.widget.ImageViewCompat
import android.widget.ImageView

@BindingAdapter("app:logoIcon")
fun logoIcon(view: ImageView, logo: LogoMark) {

    when(logo) {
        LogoMark.LOGO1 -> {
            view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.bat))
        }
        else -> {
            view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ball))
        }
    }
}
