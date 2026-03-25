package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object (Componente) que representa el menú de navegación inferior.
 * Hereda de BasePage para reutilizar la instancia del driver y mantener la arquitectura limpia.
 */
public class MenuPage extends BasePage {

    // --- Localizadores ---

    /** Localizador para el botón "Home" usando su Accessibility ID. */
    private By btnHome = AppiumBy.accessibilityId("Home");

    /** Localizador para el botón "Webview" usando su Accessibility ID. */
    private By btnWebview = AppiumBy.accessibilityId("Webview");

    /** Localizador para el botón "Login" usando su Accessibility ID. */
    private By btnLogin = AppiumBy.accessibilityId("Login");

    /** Localizador para el botón "Forms" usando su Accessibility ID. */
    private By btnForms = AppiumBy.accessibilityId("Forms");

    /** Localizador para el botón "Swipe" usando su Accessibility ID. */
    private By btnSwipe = AppiumBy.accessibilityId("Swipe");

    // --- Constructor ---

    /**
     * Constructor de la clase MenuPage.
     * Llama al constructor de la clase padre (BasePage) mediante 'super'.
     *
     * @param driver Instancia del AndroidDriver inyectada desde la prueba.
     */
    public MenuPage(AndroidDriver driver) {
        super(driver);
    }


    /**
     * Hace clic en la pestaña "Home" del menú inferior.
     */
    public void tapOnHome() {
        clickElement(btnHome);
    }

    /**
     * Hace clic en la pestaña "Webview" del menú inferior.
     */
    public void tapOnWebview() {
        clickElement(btnWebview);
    }

    /**
     * Hace clic en la pestaña "Login" del menú inferior.
     */
    public void tapOnLogin() {
        clickElement(btnLogin);
    }

    /**
     * Hace clic en la pestaña "Forms" del menú inferior.
     */
    public void tapOnForms() {
        clickElement(btnForms);
    }

    /**
     * Hace clic en la pestaña "Swipe" del menú inferior.
     */
    public void tapOnSwipe() {
        clickElement(btnSwipe);
    }
}