package vn.linh.imageapp.data.model

import android.content.Context
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import vn.linh.imageapp.R
import vn.linh.imageapp.utils.common.toTimeString
import java.util.*

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Parcelize
data class Image(
        @Expose
        val title: String?,
        @Expose
        val description: String?,
        @Expose
        val datetime: Long,
        @Expose
        @SerializedName("link")
        val thumbnail: String,
        @SerializedName("views")
        val views: Int
) : Parcelable {

    fun getDisplayTime(context: Context): String? {
        return datetime.toTimeString(context.getString(R.string.format_yyyy_MM_dd_HH_mm_ss))
    }

    fun getDisplayView(context: Context): String? {
        return ""+views+" "+context.getString(R.string.views)
    }
}