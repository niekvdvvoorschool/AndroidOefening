package com.example.insertnamehere

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log.d
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var clicks = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.apply {
            val clickspref = getInt("clicks", 0)
            clicks = clickspref;
            textView5.setText("" + clicks + " clicks")
        }

        bigButton.setOnClickListener {
            d("Niek","button was pressed")
            startActivity(Intent(this, AboutMe::class.java))
        }

        bigButton2.setOnClickListener {
            clicks++;

            val pref = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = pref.edit()
            editor.putInt("clicks", clicks).apply()

            d("Niek","Clicks: " + clicks)
            textView5.setText("" + clicks + " clicks")
        }

        bigButton3.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog(){
        val builder = AlertDialog.Builder(this@MainActivity)

        // Set the alert dialog title
        builder.setTitle("Reset clicks")

        // Display a message on alert dialog
        builder.setMessage("Are you sure you want to reset your clicks?")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("YES"){dialog, which ->
            // Do something when user press the positive button
            Toast.makeText(applicationContext,"Clicks resetted",Toast.LENGTH_SHORT).show()

            clicks = 0;

            val pref = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = pref.edit()
            editor.putInt("clicks", clicks).apply()

            d("Niek","Clicks resetted")
            textView5.setText("" + clicks + " clicks")
        }


        // Display a neutral button on alert dialog
        builder.setNeutralButton("Cancel"){_,_ ->
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
}
