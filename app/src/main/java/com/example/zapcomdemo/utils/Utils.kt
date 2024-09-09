package com.example.zapcomdemo.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso


object Utils {
    const val BANNER_IMAGE_HEIGHT = 240
    const val HORIZONTAL_BANNER_IMAGE_WIDTH_HEIGHT = 124

    fun loadImage(view: ImageView, url: String, width: Int, height: Int) {
        Picasso.get().load(url).resize(width, height).networkPolicy(NetworkPolicy.NO_STORE).memoryPolicy(MemoryPolicy.NO_CACHE)
            .into(view)
    }

    fun String.showMsg(context: Context) {
        Toast.makeText(context, this, Toast.LENGTH_LONG).show()
    }

    fun View.ViewShowHide(isVisable: Boolean) {
        if (isVisable) {
            this.visibility = View.VISIBLE
        } else {
            this.visibility = View.GONE
        }
    }
}