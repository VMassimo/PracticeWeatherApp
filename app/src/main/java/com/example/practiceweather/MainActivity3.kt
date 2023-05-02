package com.example.practiceweather

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity3 : AppCompatActivity() {
    private lateinit var name:  EditText
    private lateinit  var contact: EditText
    private lateinit var dob: EditText
    private lateinit var insert: Button
    private lateinit var update: Button
    private lateinit var delete: Button
    private lateinit var view: Button
    private lateinit var DB: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        name = findViewById(R.id.name)
        contact = findViewById(R.id.contact)
        dob = findViewById(R.id.dob)
        insert = findViewById(R.id.btnInsert)
        update = findViewById(R.id.btnUpdate)
        delete = findViewById(R.id.btnDelete)
        view = findViewById(R.id.btnView)
        DB = DBHelper(this)
        insert.setOnClickListener(View.OnClickListener {
            val nameTXT = name.getText().toString()
            val contactTXT = contact.getText().toString()
            val dobTXT = dob.getText().toString()
            val checkinsertdata = DB!!.insertuserdata(nameTXT, contactTXT, dobTXT)
            if (checkinsertdata == true) Toast.makeText(
                this@MainActivity3,
                "New Entry Inserted",
                Toast.LENGTH_SHORT
            ).show() else Toast.makeText(
                this@MainActivity3,
                "New Entry Not Inserted",
                Toast.LENGTH_SHORT
            ).show()
        })
        update.setOnClickListener(View.OnClickListener {
            val nameTXT = name.getText().toString()
            val contactTXT = contact.getText().toString()
            val dobTXT = dob.getText().toString()
            val checkupdatedata = DB!!.updateuserdata(nameTXT, contactTXT, dobTXT)
            if (checkupdatedata == true) Toast.makeText(
                this@MainActivity3,
                "Entry Updated",
                Toast.LENGTH_SHORT
            ).show() else Toast.makeText(
                this@MainActivity3,
                "New Entry Not Updated",
                Toast.LENGTH_SHORT
            ).show()
        })
        delete.setOnClickListener(View.OnClickListener {
            val nameTXT = name.getText().toString()
            val checkudeletedata = DB!!.deletedata(nameTXT)
            if (checkudeletedata == true) Toast.makeText(
                this@MainActivity3,
                "Entry Deleted",
                Toast.LENGTH_SHORT
            ).show() else Toast.makeText(this@MainActivity3, "Entry Not Deleted", Toast.LENGTH_SHORT)
                .show()
        })
        view.setOnClickListener(View.OnClickListener {
            val res = DB!!.getdata()
            if (res.count == 0) {
                Toast.makeText(this@MainActivity3, "No Entry Exists", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val buffer = StringBuffer()
            while (res.moveToNext()) {
                buffer.append(
                    """
                        Name :${res.getString(0)}
                        
                        """.trimIndent()
                )
                buffer.append(
                    """
                        Contact :${res.getString(1)}
                        
                        """.trimIndent()
                )
                buffer.append(
                    """
                        Date of Birth :${res.getString(2)}
                        
                        
                        """.trimIndent()
                )
            }
            val builder = AlertDialog.Builder(this@MainActivity3)
            builder.setCancelable(true)
            builder.setTitle("User Entries")
            builder.setMessage(buffer.toString())
            builder.show()
        })
    }
}


