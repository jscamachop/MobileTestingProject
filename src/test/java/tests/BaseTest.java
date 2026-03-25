package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Clase base para la configuración de las pruebas automatizadas móviles.
 * Gestiona la inicialización y el cierre de la sesión del driver de Appium.
 */
public class BaseTest {

    /**
     * Driver principal de Android utilizado para enviar comandos al emulador.
     */
    protected AndroidDriver driver;

    /**
     * Configura las capabilities de UiAutomator2 y establece la conexión
     * con el servidor local de Appium antes de la ejecución de cada prueba.
     * También define configuraciones como el paquete de la app y esperas implícitas.
     *
     * @throws MalformedURLException Si la URL del servidor de Appium tiene un formato incorrecto.
     */
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity")
                .setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    /**
     * Cierra de manera segura la sesión del driver de Appium después
     * de la ejecución de cada prueba para liberar los recursos del emulador.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}