package vn.linh.imageapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Parcelize
data class Image(
        val title: String,
        val description: String,
        val createdDate: Date,
        val thumbnail: String
) : Parcelable