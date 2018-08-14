package vn.linh.imageapp.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import vn.linh.imageapp.data.model.Image

data class GetImageResponse(
        @Expose
        @SerializedName("data")
        val images: List<Image>
)