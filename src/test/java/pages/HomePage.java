package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object que representa la pantalla principal (Home) de la aplicación.
 * Hereda de BasePage para obtener el driver y métodos comunes.
 */
public class HomePage extends BasePage {

    /** Localizador del contenedor principal de la pantalla Home. */
    private By homeScreen = AppiumBy.accessibilityId("Home-screen");

    /**
     * Constructor de la clase HomePage.
     * Llama al constructor de la clase padre (BasePage).
     * * @param driver Instancia del AndroidDriver.
     */
    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Valida si la pantalla Home está visible en el emulador.
     * * @return true si el elemento está visible, false en caso contrario.
     */
    public boolean isHomeVisible() {
        return isElementVisible(homeScreen); // 'driver' viene heredado de BasePage
    }
}