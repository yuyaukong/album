package com.example.album.ui.album

import com.example.album.ui.bookmark.BookmarkFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumFragment : BookmarkFragment() {

    companion object {
        fun newInstance() = AlbumFragment()
    }

    override fun isShowBookmarkOnly(): Boolean {
        return false
    }
}