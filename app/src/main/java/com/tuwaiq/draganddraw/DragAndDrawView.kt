package com.tuwaiq.draganddraw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint

import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

private const val TAG = "DragAndDrawView"

class DragAndDrawView(context:Context , attributeSet: AttributeSet) : View(context,attributeSet) {

    companion object {
        val boxes = mutableListOf<Box>()
    }

    private var currentBox: Box? = null

    private val backgroundPaint = Paint().apply {
        color = resources.getColor(R.color.black)
    }

    private val boxPaint = Paint().apply {
        color = resources.getColor(R.color.white)
    }

//    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {

        val currentPoint = PointF(event.x,event.y)

    when(event.action){

            MotionEvent.ACTION_DOWN -> {

                currentBox = Box(currentPoint).also {
                    boxes.add(it)
                }
            }

            MotionEvent.ACTION_MOVE -> {
                changeCurrentBox(currentPoint)

            }

            MotionEvent.ACTION_UP -> {
                currentBox = null
            }



//            MotionEvent.ACTION_CANCEL -> {
//                action = "ACTION_CANCEL"
//            }
        }

        Log.d(TAG, boxes.toString())

        return true
    }

     private fun changeCurrentBox (currentPoint: PointF){

        currentBox?.let {
            it.endingPoint = currentPoint
        }
        invalidate()

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawPaint(backgroundPaint)

        boxes.forEach{ box ->

            canvas.drawRect(box.left,box.top,box.right,box.bottom,boxPaint)
        }
    }

    
}