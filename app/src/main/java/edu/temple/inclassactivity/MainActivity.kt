package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method
        val fragment = ImageDisplayFragment()

        val bundle = Bundle()
        bundle.putIntArray(IMAGES_KEY,imageArray)
        fragment.arguments = bundle


        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView2,fragment)
            .commit()

        findViewById<Button>(R.id.fragmentContainerView2).setOnClickListener(
            
        )



    }
}