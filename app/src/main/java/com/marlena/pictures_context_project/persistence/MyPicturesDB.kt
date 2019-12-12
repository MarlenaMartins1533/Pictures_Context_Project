package com.marlena.pictures_context_project.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marlena.pictures_context_project.model.entity.MyPictureEntity

@Database(entities = [MyPictureEntity::class], version = 1)
abstract class MyPicturesDB : RoomDatabase() {

    companion object {
        lateinit var instance: MyPicturesDB private set

        fun initialize(applicationContext: Context) {
            instance = Room.databaseBuilder(
                applicationContext,
                MyPicturesDB::class.java,
                "mypictures.db"
            ).apply {
                allowMainThreadQueries()
            }.build()
        }
    }
    abstract fun mypicturesDAO(): MyPicturesDAO
}