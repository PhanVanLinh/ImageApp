package vn.linh.imageapp.screen.imagedetail

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import vn.linh.imageapp.R
import vn.linh.imageapp.data.model.Image
import vn.linh.imageapp.screen.BaseActivity
import vn.linh.imageapp.utils.common.ImageLoader
import vn.linh.imageapp.utils.constant.EXTRA_IMAGE
import javax.inject.Inject

const val DESCRIPTION_SHOWING_TIME = 2000L

class ImageDetailActivity : BaseActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvCreatedDate: TextView
    private lateinit var tvView: TextView
    private lateinit var ivMain: ImageView
    private lateinit var loDescription: LinearLayout
    var image: Image? = null

    @Inject
    lateinit var imageLoader: ImageLoader

    private var layoutDescriptionVisibleHandler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        initView()
        getDataFromIntent()
        updateView()
        scheduleHideDescriptionView()
    }

    override fun initView() {
        tvTitle = findViewById(R.id.text_title)
        tvDescription = findViewById(R.id.text_description)
        tvCreatedDate = findViewById(R.id.text_created_date)
        tvView = findViewById(R.id.text_view)
        ivMain = findViewById(R.id.image_main)
        loDescription = findViewById(R.id.layout_description)

        ivMain.setOnClickListener {
            scheduleHideDescriptionView()
        }
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

    private fun scheduleHideDescriptionView() {
        if (layoutDescriptionVisibleHandler == null) {
            layoutDescriptionVisibleHandler = Handler()
        }
        loDescription.visibility = View.VISIBLE
        layoutDescriptionVisibleHandler?.postDelayed({
            loDescription.visibility = View.GONE
        }, DESCRIPTION_SHOWING_TIME)
    }
}
