package com.example.imagecaption

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.renderscript.Element
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.imagecaption.ml.ModelExtratorFeacture
import org.tensorflow.lite.schema.TensorType.FLOAT32

class MainActivity : AppCompatActivity() {


//https://www.youtube.com/watch?v=o5c2BLrxNyA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// get reference to button
        val btnclickme = findViewById(R.id.button) as Button


        val textView: TextView = findViewById(R.id.textView) as TextView

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),111)
        }
// set on-click listener
        btnclickme.setOnClickListener {
            var i  = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,101)

//            val model = ModelExtratorFeacture.newInstance(this)
//
//// Creates inputs for reference.
//            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 512, 512, 3), Element.DataType.FLOAT32)
//            inputFeature0.loadBuffer(byteBuffer)
//
//// Runs model inference and gets result.
//            val outputs = model.process(inputFeature0)
//            val outputFeature0 = outputs.outputFeature0AsTensorBuffer

// Releases model resources if no longer used.
           // model.close()





            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            textView.text = "Descrição Top"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==101){
            var pic = data?.getParcelableExtra<Bitmap>("data")
            val imageView = findViewById(R.id.imageView) as ImageView
            imageView.setImageBitmap(pic)

        }
    }










}