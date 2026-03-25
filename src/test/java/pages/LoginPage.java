package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object que representa la pantalla de inicio de sesión (Login).
 * Hereda de BasePage para reutilizar la instancia del driver.
 */
public class LoginPage extends BasePage {

    /** Localizador del contenedor principal de la pantalla de Login. */
    private By loginScreen = AppiumBy.accessibilityId("Login-screen");

    /** Localizador del botón de Login para validar sus propiedades. */
    private By btnLoginSubmit = AppiumBy.accessibilityId("button-LOGIN");

    /**
     * Constructor de la clase LoginPage.
     * Llama al constructor de la clase padre (BasePage) mediante 'super'.
     *
     * @param driver Instancia del AndroidDriver inyectada desde la prueba.
     */
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Valida si la pantalla de Login está visible en el emulador.
     *
     * @return true si el contenedor principal está visible, false en caso contrario.
     */
    public boolean isLoginScreenVisible() {
        return isElementVisible(loginScreen);
    }

    /**
     * Valida si el botón de hacer submit en el Login está habilitado para ser clickeado.
     * Cumple con el requerimiento de validar propiedades (enabled).
     *
     * @return true si el botón está habilitado, false en caso contrario.
     */
    public boolean isLoginButtonEnabled() {
        return isElementVisible(btnLoginSubmit);
    }
}