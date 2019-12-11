package com.marlena.pictures_context_project.ui.persistence
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.Query
//import com.marlena.pictures_context_project.ui.model.MyPicturesRoom
//
//@Dao
//interface MyPicturesDAO {
//
//    @Query("SELECT * FROM mypicturesroom")
//    fun getAllMyPictures(): List<MyPicturesRoom>
//
//    @Insert
//    fun insertPicture(myPicture: MyPicturesRoom)
//
//    @Delete
//    fun deletePicture(myPicture: MyPicturesRoom)
//}