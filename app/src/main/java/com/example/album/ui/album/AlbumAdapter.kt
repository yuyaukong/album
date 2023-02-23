package com.example.album.ui.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.album.databinding.LayoutAlbumBinding
import com.example.album.model.Product


class AlbumAdapter(
    private val onItemClicked: (Product) -> Unit,
    private val isShowBookmarkOnly: Boolean
): RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private var mProductList: List<Product> = listOf()

    class ViewHolder(binding: LayoutAlbumBinding) : RecyclerView.ViewHolder(binding.root) {

        private val mBinding: LayoutAlbumBinding

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
        binding.root.setOnClickListener {
            binding.product?.let(onItemClicked)
        }
        binding.isBookmarkVisible = !isShowBookmarkOnly
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
        mProductList = if (isShowBookmarkOnly) {
            productList.filter {
                it.isBookmark
            }
        } else {
            productList
        }
        notifyDataSetChanged()
    }
}
