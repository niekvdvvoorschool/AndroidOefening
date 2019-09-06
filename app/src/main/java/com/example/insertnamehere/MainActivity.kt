package com.example.insertnamehere

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var clicks = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bigButton.setOnClickListener {
            d("Niek","button was pressed")
            startActivity(Intent(this, AboutMe::class.java))
        }

        bigButton2.setOnClickListener {
            clicks++;
            d("Niek","Clicks: " + clicks)
            textView5.setText("" + clicks + " clicks")
        }

        bigButton3.setOnClickListener {
            clicks = 0;
            d("Niek","Clicks resetted")
            textView5.setText("" + clicks + " clicks")
        }
    }
}
