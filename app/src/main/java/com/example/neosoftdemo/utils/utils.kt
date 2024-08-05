package com.example.neosoftdemo.utils

import android.widget.ImageView
import com.example.core.data.source.local.entity.ItemEntity
import com.squareup.picasso.Picasso

object utils {
    fun loadImage(view: ImageView, url: String) {
        Picasso.get().apply {
            load(url).into(view)
        }
    }

    fun countLatter(listList: ArrayList<String>, label: String): String {
        var totalLatterCount = ""
        val vowels = listOf(
            'a',
            'b',
            'c',
            'd',
            'e',
            'f',
            'g',
            'h',
            'i',
            'j',
            'k',
            'l',
            'm',
            'n',
            'o',
            'p',
            'q',
            'r',
            's',
            't',
            'v',
            'w',
            'x',
            'y',
            'z'
        )
        val maps: MutableMap<Char, Int> = HashMap()
        for (i in 0..listList.size - 1) {
            val char = listList.get(i).lowercase().first()
            if (char in vowels) {
                if (maps.containsKey(char)) {
                    maps[char] = maps[char]!! + 1
                } else {
                    maps[char] = 1
                }
            }
        }
        for ((key, value) in maps) {
            totalLatterCount = totalLatterCount + label + "  ${key.uppercase()} :  $value \n"
        }
        return totalLatterCount
    }

    fun getAllItemTitleArray(listList: ArrayList<ItemEntity>): ArrayList<String> {
        val listItemTitle = ArrayList<String>()
        for (i in 0..listList.size - 1) {
            listItemTitle.add(listList.get(i).title)
        }

        return listItemTitle
    }
}