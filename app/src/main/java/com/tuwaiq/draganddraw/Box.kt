package com.tuwaiq.draganddraw

import android.graphics.PointF

class Box(private val startingPoint : PointF ) {

    var endingPoint = startingPoint

    val left:Float
            get() = Math.min(startingPoint.x,endingPoint.x)

    val right:Float
            get() = Math.max(startingPoint.x,endingPoint.x)

    val top:Float
            get() = Math.min(startingPoint.y,endingPoint.y)

    val bottom:Float
            get() = Math.max(startingPoint.y,endingPoint.y)


}