package com.example.album.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.album.R
import com.example.album.databinding.FragmentAlbumBinding
import com.example.album.model.Product
import com.example.album.ui.album.AlbumAdapter
import com.example.album.ui.album.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
open class BookmarkFragment : Fragment(R.layout.fragment_bookmark) {

    companion object {
        fun newInstance() = BookmarkFragment()
    }

    private lateinit var mBinding: FragmentAlbumBinding
    private lateinit var mAdapter: AlbumAdapter

    private val viewModel: AlbumViewModel by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mBinding = FragmentAlbumBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.apply {
            mBinding.productListView.setupView()
            viewModel.productList.observe(viewLifecycleOwner) {
                mAdapter.updateData(it)
            }
        }
    }

    private fun RecyclerView.setupView() {
        val onItemClicked: (product: Product) -> Unit = { product ->
            viewModel.onClick(product)
        }
        mAdapter = AlbumAdapter(onItemClicked, isShowBookmarkOnly())
        this.adapter = mAdapter
        this.layoutManager = initGridLayoutManager()
    }

    private fun initGridLayoutManager(): GridLayoutManager {
        return GridLayoutManager(requireContext(), 2)
    }

    open fun isShowBookmarkOnly(): Boolean {
        return true
    }
}