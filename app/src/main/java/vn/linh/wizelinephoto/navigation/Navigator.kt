package vn.linh.wizelinephoto.navigation

import android.content.Context
import android.content.Intent
import vn.linh.wizelinephoto.data.model.Image
import vn.linh.wizelinephoto.screen.imagedetail.ImageDetailActivity
import vn.linh.wizelinephoto.utils.constant.EXTRA_IMAGE

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
