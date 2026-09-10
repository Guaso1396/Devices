# Devices App

Aplicación Android desarrollada en Android Studio con Kotlin y Jetpack Compose que consume la API pública de https://api.restful-api.dev para mostrar un catálogo de dispositivos electrónicos como teléfonos, tablets, relojes y audífonos.

---

## Descripción

La app obtiene una lista de dispositivos desde el endpoint /objects y los presenta en una lista desplazable con su nombre, color, capacidad y precio. Cada ítem incluye un ícono de teléfono y un separador visual.

Proyecto desarrollado en Android Studio, versión Ladybug o superior.

---

## Características principales

* Lista desplazable de dispositivos electrónicos
* Muestra nombre, color, capacidad y precio de cada dispositivo
* Ícono de teléfono en cada ítem
* Separador visual entre elementos
* Consumo de API REST con Retrofit
* Manejo de datos inconsistentes mediante SerializedName con alternate

---

## Tecnologías utilizadas

* Kotlin
* Jetpack Compose
* Material 3
* Retrofit 2
* Gson
* Coroutines
* ViewModel / Lifecycle
* Gradle Kotlin DSL
* Version Catalog (libs.versions.toml)

---

## Estructura del proyecto

El proyecto se organiza en el paquete com.example.myapplication o similar, con los siguientes archivos principales:

* MainActivity.kt: punto de entrada y configuración de Compose
* MainScreen.kt: pantalla principal que muestra la lista de dispositivos
* DeviceItem.kt: Composable que renderiza cada dispositivo
* DeviceService.kt: interfaz Retrofit para consumir la API
* Modelos de datos: Device y Specs
* Archivos de tema y configuración de Gradle

---

## Requisitos

* Android Studio Ladybug o superior
* JDK 17 o 21
* compileSdk 35
* minSdk 24
* targetSdk 35
* Conexión a internet

No usar Java 25 con Gradle 8.9.

---

## Configuración

1. Clonar el repositorio
2. Configurar Gradle JDK en Android Studio con JDK 17 o 21
3. Sincronizar el proyecto
4. Ejecutar en un emulador o dispositivo físico

---

## API

La aplicación utiliza la base URL https://api.restful-api.dev y el endpoint GET /objects.

La API devuelve una lista de dispositivos. Cada dispositivo tiene id, name y data. El campo data puede contener color, capacity y price, aunque no todos los dispositivos incluyen los mismos campos.

---

## Modelos Kotlin

El modelo Device tiene los campos id, name y data. El campo data es de tipo Specs y puede ser nulo.

El modelo Specs tiene los campos color, capacity y price. Todos son opcionales. Se usa SerializedName con alternates para manejar variaciones en las claves del JSON, por ejemplo Color, Capacity, capacity GB y Price.

---

## Arquitectura

La UI en MainActivity y Compose llama a MainScreen y DeviceItem. Luego se comunica con DeviceService mediante Retrofit. Finalmente, se conecta con la API externa.

---

## Problemas conocidos

* Java 25 no está soportado; usar JDK 17 o 21
* Si falta android.useAndroidX, agregarlo en gradle.properties
* La API puede devolver datos inconsistentes; usar SerializedName con alternate
* Algunos dispositivos no traen todos los campos; validar nulos

---

## Mejoras futuras

* Implementar ViewModel con StateFlow
* Añadir manejo de estados de carga y error
* Crear pantalla de detalle
* Agregar caché con Room
* Realizar pruebas unitarias
* Incluir búsqueda y filtrado

---

## Autor

Tu Nombre
https://github.com/Guaso1396
