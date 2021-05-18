package com.example.a7minuteworkout

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogForBackButton: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Are you sure?")
                    .setMessage("This will stop your workout. You\'ve come this far, are you sure you want to quit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            DialogInterface.OnClickListener { dialog, id ->
                                activity!!.finish()
                                dialog.cancel()
                            })
                    .setNegativeButton("No",
                            DialogInterface.OnClickListener { dialog, id ->
                                dialog.cancel()
                            })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}