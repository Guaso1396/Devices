package com.example.devices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.devices.ui.theme.DevicesTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevicesTheme {
                var devices by remember { mutableStateOf(value = listOf<Device>()) }

                LaunchedEffect(Unit) {
                    getDevices { result ->
                        devices = result
                    }
                }

                Scaffold(Modifier.fillMaxSize()) { innerPadding ->
                    MainView(
                        Modifier.padding(paddingValues = innerPadding),
                        devices = devices
                    )
                }
            }
        }
    }

    private fun getDevices(onResult: (List<Device>) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DeviceService::class.java)

        lifecycleScope.launch {
            val devices = service.getAllDevices()
            onResult(devices)
        }
    }
}