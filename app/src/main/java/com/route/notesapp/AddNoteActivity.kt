package com.route.notesapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.route.notesapp.Database.Model.Note
import com.route.notesapp.Database.MyDataBase
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        add_note_activity_btn_add.setOnClickListener(View.OnClickListener {
            val title = add_note_activity_et_title.text.toString()
            val desc = add_note_activity_et_desc.text.toString()
            val date = add_note_activity_et_date.text.toString()

            val note = Note(title = title,
                description = desc,
                time = date)

            MyDataBase.getInstance(applicationContext)
                ?.notesDao()
                ?.insertNote(note = note)
            showSuccessMessage()
        })
    }

    fun showSuccessMessage(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.note_add_successfully)
        builder.setPositiveButton(R.string.ok, DialogInterface.OnClickListener {
                dialogInterface, i ->
            dialogInterface.dismiss()
            finish()
        })
        builder.setCancelable(false)
        builder.show()
    }

}