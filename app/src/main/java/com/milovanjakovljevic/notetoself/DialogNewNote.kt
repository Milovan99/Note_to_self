package com.milovanjakovljevic.notetoself

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogNewNote:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder= AlertDialog.Builder(requireActivity())
        val inflater=requireActivity().layoutInflater
        val dialogView=inflater.inflate(R.layout.dialog_new_note,null)

        val editTitle=dialogView.findViewById(R.id.editTitle) as EditText
        val editDescription=dialogView.findViewById(R.id.editDescription) as EditText
        val checkBoxIdea=dialogView.findViewById(R.id.checkBoxIdea) as CheckBox
        val checkBoxToDo = dialogView.findViewById(R.id.checkBoxToDo) as CheckBox
        val checkBoxImportant=dialogView.findViewById(R.id.checkBoxImportant) as CheckBox

        val bntCancel=dialogView.findViewById(R.id.btnCancel) as Button
        val bntOK=dialogView.findViewById(R.id.btnOK) as Button

        return super.onCreateDialog(savedInstanceState)
    }
}