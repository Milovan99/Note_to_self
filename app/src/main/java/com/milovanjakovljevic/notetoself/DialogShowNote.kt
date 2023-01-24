package com.milovanjakovljevic.notetoself

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class DialogShowNote : DialogFragment() {
    private var note :Note?=null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=AlertDialog.Builder(requireActivity())
        val inflater=requireActivity().layoutInflater
        val dialogView=inflater.inflate(R.layout.dialog_show_note,null)
        val txtTitle=dialogView.findViewById(R.id.txtTitle) as TextView
        val txtDescription=dialogView.findViewById(R.id.txtDescription) as TextView
        txtTitle.text=note!!.title
        txtDescription.text=note!!.description

        val txtImportant=dialogView.findViewById(R.id.textViewImportant) as TextView
        val txtToDo = dialogView.findViewById(R.id.textViewToDo) as TextView
        val txtIdea=dialogView.findViewById(R.id.textViewIdea) as TextView

        if(!note!!.important){
            txtImportant.visibility= View.GONE

        }
        if(!note!!.todo){
            txtToDo.visibility=View.GONE
        }
        if(!note!!.idea){
            txtIdea.visibility=View.GONE
        }

        val btnOK=dialogView.findViewById(R.id.btnOK) as Button
        builder.setView(dialogView).setMessage(resources.getString(R.string.your_note))

        btnOK.setOnClickListener{
            dismiss()
        }
        return builder.create()
    }

    fun sendNoteSelected(noteSelected:Note){
        note=noteSelected
    }
}