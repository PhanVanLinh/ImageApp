package vn.linh.imageapp.screen.image

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import vn.linh.imageapp.R
import vn.linh.imageapp.data.model.Image
import vn.linh.imageapp.navigation.Navigator
import vn.linh.imageapp.screen.BaseActivity
import vn.linh.imageapp.screen.image.adapter.ImageAdapter
import vn.linh.imageapp.utils.common.ImageLoader
import java.util.*
import javax.inject.Inject

class ImageActivity : BaseActivity(), ImageContract.View {

    lateinit var rvImage: RecyclerView
    var imageAdapter: ImageAdapter? = null

    @Inject
    lateinit var presenter: ImageContract.Presenter

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        initView()
        initRecyclerView()

        getImage()
    }

    override fun initView() {
        rvImage = findViewById(R.id.recycler_view_image)
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(applicationContext)
        rvImage.layoutManager = layoutManager
        imageAdapter = ImageAdapter(object : ImageAdapter.OnImageClickedListener {
            override fun onImageClicked(image: Image) {
                navigator.startImageDetail(this@ImageActivity, image)
            }
        }, imageLoader)

        rvImage.adapter = imageAdapter
      //  imageAdapter?.submitList(getData())
    }

    override fun onGetImageSuccess(images: List<Image>) {
        imageAdapter?.submitList(images)
    }

    override fun onGetImageFailed(exception: Throwable) {
    }

    fun getImage() {
        presenter.getImage()
    }
}
