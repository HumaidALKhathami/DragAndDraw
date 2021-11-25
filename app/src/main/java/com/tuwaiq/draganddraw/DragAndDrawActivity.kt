package com.tuwaiq.draganddraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DragAndDrawActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_and_draw)
    }

    override fun onBackPressed() {
        if (DragAndDrawView.boxes.isEmpty()) {
            super.onBackPressed()
        }else{
            val lastIndex = DragAndDrawView.boxes.lastIndex
            DragAndDrawView.boxes.removeAt(lastIndex)
            DragAndDrawView.
        }
    }
}