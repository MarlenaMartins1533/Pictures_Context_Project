package com.marlena.pictures_context_project.ui.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marlena.pictures_context_project.ui.model.MyPicturesRoom

@Database(entities = [MyPicturesRoom::class], version = 1)
abstract class MyPicturesDB : RoomDatabase() {

    companion object {
        lateinit var instance: MyPicturesDB private set

        fun initialize(context: Context) {
            instance = Room.databaseBuilder(
                context,
                MyPicturesDB::class.java,
                "mypictures.db"
            ).apply {
                allowMainThreadQueries()
            }.build()
        }
    }
    abstract fun mypicturesDAO(): MyPicturesDAO
}