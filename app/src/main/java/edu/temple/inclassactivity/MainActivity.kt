package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method
        val fragment = ImageDisplayFragment()

        val bundle = Bundle()
        bundle.putIntArray(IMAGES_KEY,imageArray)
        fragment.arguments = bundle

        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) !is ImageDisplayFragment){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView2,fragment)
                .commit()

        }


        override fun onContextItemSelected(item: Int){
            Toast.makeText(this,"You selected $itemID", Toast.LENGTH_SHORT).show()
        }



    }
}