package vn.linh.imageapp.utils.common

import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject

class ImageLoader @Inject constructor() {

    fun loadImage(url: String, @DrawableRes placeholder: Int, imageView: ImageView) {
        Picasso.get()
                .load(url)
                .fit()
                .placeholder(placeholder)
                .into(imageView)
    }
}