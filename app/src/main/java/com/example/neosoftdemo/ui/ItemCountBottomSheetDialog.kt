package com.example.neosoftdemo.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.neosoftdemo.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ItemCountBottomSheetDialog(labelItemCount: String, totalLatterCount: String) :
    BottomSheetDialogFragment() {
    private var labelItemCount = labelItemCount
    private var totalLatterCount = totalLatterCount
    lateinit var mItemCount: TextView
    lateinit var mLatterCount: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_dialog_layout, container, false)
        mItemCount = view.findViewById(R.id.text_total_item_count)
        mLatterCount = view.findViewById(R.id.text_latter_count)

        mItemCount.apply {
            text = labelItemCount
        }

        mLatterCount.apply {
            text = totalLatterCount
        }

        return view
    }
}