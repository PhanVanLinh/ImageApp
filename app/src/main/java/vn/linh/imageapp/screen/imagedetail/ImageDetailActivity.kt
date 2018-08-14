package vn.linh.imageapp.screen.imagedetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import vn.linh.imageapp.R
import vn.linh.imageapp.data.model.Image
import vn.linh.imageapp.screen.BaseActivity
import vn.linh.imageapp.utils.common.ImageLoader
import vn.linh.imageapp.utils.constant.EXTRA_IMAGE
import javax.inject.Inject

class ImageDetailActivity : BaseActivity() {
    lateinit var tvTitle: TextView
    lateinit var tvDescription: TextView
    lateinit var tvCreatedDate: TextView
    lateinit var tvView: TextView
    lateinit var ivMain: ImageView
    var image: Image? = null

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        initView()
        getDataFromIntent()
        updateView()

    }

    override fun initView() {
        tvTitle = findViewById(R.id.text_title)
        tvDescription = findViewById(R.id.text_description)
        tvCreatedDate = findViewById(R.id.text_created_date)
        tvView = findViewById(R.id.text_view)
        ivMain = findViewById(R.id.image_main)
    }

    override fun getDataFromIntent() {
        image = intent.getParcelableExtra(EXTRA_IMAGE)
    }

    override fun updateView() {
        image?.let {
            tvTitle.text = it.title
            tvDescription.text = it.description
            tvCreatedDate.text = it.getDisplayTime(this)
            tvView.text = it.getDisplayView(this)
            imageLoader.loadImage(it.thumbnail, R.drawable.image_placeholder, ivMain)
        }
    }


}
