package com.example.album.ui.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.album.R
import com.example.album.databinding.FragmentAlbumBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumFragment : Fragment(R.layout.fragment_album) {

    companion object {
        fun newInstance() = AlbumFragment()
    }

    private lateinit var mBinding: FragmentAlbumBinding
    private lateinit var mAdapter: AlbumAdapter

    private val viewModel: AlbumViewModel by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mBinding = FragmentAlbumBinding.inflate(inflater, container, false)

        mBinding.productListView.setupView()

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.apply {
            viewModel.productList.observe(viewLifecycleOwner) {
                mAdapter.updateData(it)
            }
        }
    }

    private fun RecyclerView.setupView() {
        mAdapter = AlbumAdapter()
        this.adapter = mAdapter
        this.layoutManager = initGridLayoutManager()
    }

    private fun initGridLayoutManager(): GridLayoutManager {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        return layoutManager
    }
}