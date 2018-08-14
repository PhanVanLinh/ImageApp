package vn.linh.imageapp.navigation

import android.content.Context
import android.content.Intent
import vn.linh.imageapp.data.model.Image
import vn.linh.imageapp.screen.imagedetail.ImageDetailActivity
import vn.linh.imageapp.utils.constant.EXTRA_IMAGE

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class Navigator {

    fun startImageDetail(context: Context, image: Image) {
        val intent = Intent(context, ImageDetailActivity::class.java)
        intent.putExtra(EXTRA_IMAGE, image)
        context.startActivity(intent)
    }
}
