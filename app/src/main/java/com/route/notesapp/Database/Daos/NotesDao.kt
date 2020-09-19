package com.route.notesapp.Database.Daos

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.route.notesapp.Database.Model.Note
import androidx.room.Insert as Insert

@Dao
interface NotesDao {
    @Insert
    fun insertNote(note: Note)
    @Delete
    fun deleteNote(note: Note)
    @Update
    fun updateNote(note: Note)

    @Query("select * from Note")
    fun selectAllNotes():List<Note>
    @Query("select * from Note Where description Like :keyWord")
    fun searchNotesByDescription(keyWord:String):List<Note>
    @Query("delete from Note where id = :id")
    fun deleteNoteById(id:String)
}