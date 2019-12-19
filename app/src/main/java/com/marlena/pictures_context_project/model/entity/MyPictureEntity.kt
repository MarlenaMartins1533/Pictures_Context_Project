package com.marlena.pictures_context_project.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "mypicture")
class MyPictureEntity: Serializable {

    @PrimaryKey
    @ColumnInfo(name = "url")
    var url: String = "url"
    @ColumnInfo(name = "name")
    var name: String = "Atenção"
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = true
    @ColumnInfo(name = "desc")
    var sensations: String = "sensations"
}