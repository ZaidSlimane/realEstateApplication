package com.example.realestateapplication.Presentation

import android.content.Context
import android.icu.text.Transliterator
import android.view.SurfaceView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import io.github.sceneview.Scene
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberEnvironmentLoader
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes


@Composable
fun Visualizer3DScreen() {

    val lifecycleOwner = LocalLifecycleOwner.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AndroidView(factory = { context ->
            val renderer = ModelRenderer()

            SurfaceView(context).apply {
                renderer.onSurfaceAvailable(this, lifecycleOwner.lifecycle )
            }
        })

    }
}



