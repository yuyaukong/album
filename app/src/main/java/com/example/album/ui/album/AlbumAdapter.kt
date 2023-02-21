package com.example.album.ui.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.album.R
import com.example.album.databinding.LayoutAlbumBinding
import com.example.album.model.Product


class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private var mProductList: List<Product> = listOf()

    class ViewHolder(binding: LayoutAlbumBinding) : RecyclerView.ViewHolder(binding.root) {

        val mBinding: LayoutAlbumBinding

        init {
            mBinding = binding
        }

        fun bind(product: Product) {
            mBinding.product = product
            mBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val product = mProductList[position]
        viewHolder.bind(product)
    }

    override fun getItemCount(): Int {
        return mProductList.size
    }

    fun updateData(productList: List<Product>) {
        mProductList = productList
        notifyDataSetChanged()
    }
}
