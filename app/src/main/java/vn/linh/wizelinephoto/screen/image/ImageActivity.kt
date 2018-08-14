package vn.linh.wizelinephoto.screen.image

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import vn.linh.wizelinephoto.R
import vn.linh.wizelinephoto.data.model.Image
import vn.linh.wizelinephoto.navigation.Navigator
import vn.linh.wizelinephoto.screen.base.BaseActivity
import vn.linh.wizelinephoto.screen.image.adapter.ImageAdapter
import java.util.*
import javax.inject.Inject

class ImageActivity : BaseActivity(), ImageContract.View {

    lateinit var rvImage: RecyclerView
    var imageAdapter: ImageAdapter? = null

    @Inject
    lateinit var presenter: ImageContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        initView()
        initRecyclerView()

        login()
    }

    override fun initView() {
        rvImage = findViewById(R.id.recycler_view_image)
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(applicationContext)
        rvImage.layoutManager = layoutManager
        imageAdapter = ImageAdapter(object : ImageAdapter.OnImageClickedListener {
            override fun onImageClicked(image: Image) {
                Navigator().startImageDetail(this@ImageActivity, image)
            }
        })

        rvImage.adapter = imageAdapter
        imageAdapter?.submitList(getData())
    }

    fun login() {
        presenter.login("ABC")
    }

    fun getData(): MutableList<Image> {
        val list = mutableListOf<Image>()

        list.add(Image("1", "2", Date(), ""))
        list.add(Image("1", "2", Date(), ""))
        list.add(Image("1", "2", Date(), ""))
        return list
    }
}
