# 📱 Proyecto MobileTesting

Este proyecto es un framework de pruebas automatizadas para la aplicación de demostración de WebdriverIO (`wdiodemoapp`). Está construido usando **Java, Appium y TestNG**, aplicando el patrón de diseño **Page Object Model (POM)** para garantizar un código limpio y mantenible.

## 🛠️ Tecnologías y Herramientas

* **Lenguaje:** Java version 17
* **Core de Automatización:** Appium (UiAutomator2) + Selenium WebDriver
* **Gestor de Pruebas:** TestNG
* **Patrón de Diseño:** Page Object Model (POM)
* **IDE Recomendado:** IntelliJ IDEA

## ⚙️ Requisitos Previos

Para ejecutar estas pruebas en tu máquina local, necesitas tener instalado lo siguiente:

1.  **Java JDK** (versión 11 o superior).
2.  **Node.js y NPM** para poder instalar Appium.
3.  **Appium Server** (instalado de forma global vía npm).
4.  **Android Studio** con un emulador configurado y corriendo (por defecto: `emulator-5554`).
5.  La aplicación de prueba **WebdriverIO Demo App** instalada en el emulador.

## 📁 Estructura del Proyecto

El proyecto está dividido en dos capas principales para separar la lógica de negocio de las aserciones:

* `/pages`: Contiene todas las clases que representan las pantallas de la aplicación (`BasePage`, `LoginPage`, `SwipePage`, etc.). Aquí viven los localizadores (XPath, Accessibility ID) y las acciones (clics, swipes, escritura).
* `/tests`: Contiene los scripts de prueba (`LoginTest`, `NavigationTest`, `SwipeCardsTest`, etc.). Aquí se manejan las precondiciones, el flujo de la prueba y las validaciones (Asserts).

## 🚀 Cómo ejecutar las pruebas

1.  Abre tu terminal y enciende el servidor de Appium ejecutando el comando:
    ```bash
    appium
    ```
2.  Abre Android Studio e inicia tu **Emulador de Android**.
3.  Abre este proyecto en **IntelliJ IDEA**.
4.  Navega a la carpeta `src/test/java/tests/`.
5.  Haz clic derecho sobre cualquier clase de prueba (por ejemplo, `NavigationTest.java`) y selecciona **Run 'NavigationTest'**.

## 🧪 Casos de Prueba Cubiertos

* **NavigationTest:** Valida la navegación completa por la barra inferior y el menú lateral.
* **LoginTest:** Verifica el flujo de inicio de sesión exitoso usando credenciales generadas dinámicamente.
* **SignUpTest:** Verifica la creación de usuarios nuevos asegurando la independencia de datos.
* **SwipeCardsTest:** Automatiza gestos complejos táctiles (Scroll vertical y Swipe horizontal) para encontrar elementos ocultos.
