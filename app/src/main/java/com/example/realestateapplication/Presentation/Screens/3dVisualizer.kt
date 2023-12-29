/*package com.example.realestateapplication.Presentation

import android.view.SurfaceView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle


@Composable
fun Visualizer3DScreen(lifecycle: Lifecycle) {

   // val lifecycleOwner = LocalLifecycleOwner.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background

    ) {
        AndroidView(factory = { context ->
           // val renderer = ModelRenderer()

            SurfaceView(context).apply {
                renderer.onSurfaceAvailable(this,  lifecycle )
            }
        })

    }
}



 */

