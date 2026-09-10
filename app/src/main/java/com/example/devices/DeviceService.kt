package com.example.devices

import retrofit2.http.GET

interface DeviceService {
    @GET(value = Constants.OBJECTS_PATH)
    suspend fun getAllDevices(): List<Device>
}