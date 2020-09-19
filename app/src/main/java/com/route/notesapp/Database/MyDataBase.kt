package com.route.notesapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.notesapp.Database.Daos.NotesDao
import com.route.notesapp.Database.Model.Note


@Database(entities = arrayOf(Note::class), exportSchema = false, version = 1)
abstract class MyDataBase : RoomDatabase(){

    abstract fun notesDao(): NotesDao

    companion object{
        private var myDataBaseInstance: MyDataBase?=null
        fun getInstance(context: Context): MyDataBase?{
            if(myDataBaseInstance == null){
                myDataBaseInstance =
                    Room.databaseBuilder(context,
                        MyDataBase::class.java,"NotesDataBase")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            return myDataBaseInstance
        }
    }
}