package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title : String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)


object DummyWish{

    val wishList = listOf(
        Wish(title = "Google Watch 2",
            description = "I want the latest smart Watch"),

        Wish(title = "Ferrari",
            description = "Driving the latest Ferrari"),

        Wish(title = "Villa",
            description = "Livin on the beach")
    )
}