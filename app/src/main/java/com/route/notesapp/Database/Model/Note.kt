package com.route.notesapp.Database.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(
    @ColumnInfo
    val title:String,
    @ColumnInfo
    val description:String,
    @ColumnInfo
    val time:String){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}