package vn.linh.imageapp.screen.image.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import vn.linh.imageapp.R
import vn.linh.imageapp.data.model.Image

class ImageAdapter(private val onImageClickedListener: OnImageClickedListener) : ListAdapter<Image, ImageAdapter.ContactViewHolder>(DIFF_CALLBACK) {
    var TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_image,
                parent, false)
        return ContactViewHolder(itemView, onImageClickedListener)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val image = getItem(position)
        holder.bind(image)
    }

    class ContactViewHolder(itemView: View, onImageClickedListener: OnImageClickedListener) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.text_title)
        var tvDescription: TextView = itemView.findViewById(R.id.text_description)
        var tvCreatedDate: TextView = itemView.findViewById(R.id.text_created_date)
        var ivThumb: ImageView = itemView.findViewById(R.id.image_thumbs)
        var image: Image? = null

        init {
            itemView.setOnClickListener {
                image?.let {
                    onImageClickedListener.onImageClicked(it)
                }
            }
        }

        fun bind(image: Image) {
            this.image = image
            tvTitle.text = image.title
            tvDescription.text = image.description
            tvCreatedDate.text = image.createdDate.toString()
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
                return true
            }

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem === newItem
            }
        }
    }

    interface OnImageClickedListener {
        fun onImageClicked(image: Image)
    }
}