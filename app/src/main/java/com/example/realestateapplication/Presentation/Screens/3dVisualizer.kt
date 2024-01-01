package com.example.realestateapplication.Presentation

import android.view.SurfaceView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SweepGradientShader
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import com.example.realestateapplication.Presentation.Screens.SweepGradientExample
import io.github.sceneview.Scene
import io.github.sceneview.SceneView
import io.github.sceneview.loaders.ModelLoader
import io.github.sceneview.math.Position
import io.github.sceneview.math.Rotation
import io.github.sceneview.model.ModelInstance
import io.github.sceneview.node.ModelNode
import io.github.sceneview.node.Node
import io.github.sceneview.rememberCameraNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberEnvironmentLoader
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes


@Composable
fun Visualizer3DScreen() {

    // val lifecycleOwner = LocalLifecycleOwner.current
    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)

    TODO("NEED AN ENV ASAP")

    val environmentLoader = rememberEnvironmentLoader(engine)
    Scene(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(0.5f)
            .background(Color.Transparent)
            .padding(16.dp),
        engine = engine,
        modelLoader = modelLoader,
        childNodes = rememberNodes {
            val modelNode = ModelNode(modelLoader.createModelInstance("models/batman.glb")).apply {
                // Center the model in the scene
                position = Position(x = 0.0f, y = 0.0f, z = -5.0f)
                // Ensure model's origin is centered for accurate rotation
                centerOrigin(Position(0.0f, 0.0f, 0.0f))
                Rotation(59.0f, 59f, 59.0f)
            }
            add(modelNode)
        },
    )
}






