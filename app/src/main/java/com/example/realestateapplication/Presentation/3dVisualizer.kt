package com.example.realestateapplication.Presentation

import android.icu.text.Transliterator
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.sceneview.Scene
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberEnvironmentLoader
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes


@Composable
fun Visualizer3DScreen(){

    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)
    val environmentLoader = rememberEnvironmentLoader(engine)
    Scene(
        modifier = Modifier.fillMaxSize(),
        engine = engine,
        modelLoader = modelLoader,
        childNodes = rememberNodes {
            add(ModelNode(modelLoader.createModelInstance("")).apply {
                // Move the node 4 units in Camera front direction
                position = Position(z = -3.0f, x = 0.0f, y = -1.0f)
            })
        }
    )
}



