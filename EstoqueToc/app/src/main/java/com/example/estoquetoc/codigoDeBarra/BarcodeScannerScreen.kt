package com.example.estoquetoc.codigoDeBarra

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.google.zxing.integration.android.IntentIntegrator

private const val CAMERA_REQUEST_CODE = 100

fun checkCameraPermission(activity: Activity) {
    if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.CAMERA),
            CAMERA_REQUEST_CODE
        )
    }
}

@Composable
fun BarcodeScannerScreen() {
    var scanResult by remember { mutableStateOf("Nenhum código escaneado") }
    val activity = LocalContext.current as? Activity

    val barcodeLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val intentResult = IntentIntegrator.parseActivityResult(
            result.resultCode, result.data
        )
        scanResult = if (intentResult != null && intentResult.contents != null) {
            Log.d("Barcode", "Código: ${intentResult.contents}")
            "Código: ${intentResult.contents}"
        } else {
            "Leitura cancelada ou falhou"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            activity?.let {
                checkCameraPermission(it)
                val integrator = IntentIntegrator(it)
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
                integrator.setPrompt("Escaneie um código de barras")
                integrator.setBeepEnabled(true)
                integrator.setOrientationLocked(true)
                integrator.captureActivity = CustomCaptureActivity::class.java
                barcodeLauncher.launch(integrator.createScanIntent())
            }
        }) {
            Text("Iniciar Leitura")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = scanResult)
    }
}
