package com.marlena.pictures_context_project.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.marlena.pictures_context_project.model.entity.MyPictureEntity

@Dao
interface MyPicturesDAO {

    @Query("SELECT * FROM mypicture")
    fun getAllMyPictures(): List<MyPictureEntity>

    @Query("SELECT * FROM mypicture WHERE url = :url")
    fun getByUrl(url: String): MyPictureEntity

    @Insert
    fun insert(myPicture: MyPictureEntity)

    @Delete
    fun delete(myPicture: MyPictureEntity)
}