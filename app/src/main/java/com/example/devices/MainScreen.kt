package com.example.devices

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devices.ui.theme.DevicesTheme
import com.example.devices.ui.theme.Typography

@Composable
fun MainView(modifier: Modifier, devices: List<Device>) {
    Column(modifier) {
        Text(
            text = "Comprar",
            modifier = Modifier.fillMaxWidth(),
            style = Typography.displayMedium,
            textAlign = TextAlign.Center
        )

        LazyColumn {
            items(count = devices.size) { index ->
                DeviceItemView(devices[index])
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview() {
    DevicesTheme {
        MainView(Modifier.padding(top = 24.dp), devices = listOf(
            Device(id = 1, name = "Nexus", data = Specs(color = "Black", capacity = "64 GB", price = 149.9f)),
            Device(id = 2, name = "Galaxy", data = null)
        ))
    }
}