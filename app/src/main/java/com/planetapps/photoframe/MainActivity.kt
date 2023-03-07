package com.planetapps.photoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView
    var names = arrayOf("Nithin Kamath;ZERODHA", "Ritesh Agarwal;OYO", "Vijay Shekhar Sharma;PAYTM", "Sriharsha Majety,Nandan Reddy,Rahul Jaimini;SWIGGY")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.imgPrev)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.textView)

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (4+ currentImage-1)%4
            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentImage]
        }

   next.setOnClickListener {
       val idCurrentImageString = "pic$currentImage"
       val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
       image = findViewById(idCurrentImageInt)
       image.alpha= 0f

       currentImage = (4+ currentImage+1)%4
       val idImageToShowString = "pic$currentImage"
       val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
       image = findViewById(idImageToShowInt)
       image.alpha= 1f
       text.text = names[currentImage]
   }
    }
}