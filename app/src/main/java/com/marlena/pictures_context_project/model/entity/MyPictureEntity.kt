package com.marlena.pictures_context_project.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "mypicture")
class MyPictureEntity: Serializable {

    @PrimaryKey
    @ColumnInfo(name = "url")
    val url: String = ""
    @ColumnInfo(name = "name")
    val name: String = "Atenção"

//    @ColumnInfo(name = "favorite")
//    val favorite: Boolean = true
//    @ColumnInfo(name = "desc")
//    val sensation: String = ""
}