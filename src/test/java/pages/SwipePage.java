package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object que representa la pantalla de Swipe.
 * Hereda de BasePage para reutilizar la instancia del driver y mantener una arquitectura limpia.
 */
public class SwipePage extends BasePage {

    /** Localizador del contenedor principal de la pantalla Swipe. */
    private By swipeScreen = AppiumBy.accessibilityId("Swipe-screen");

    /**
     * Constructor de la clase SwipePage.
     * Llama al constructor de la clase padre (BasePage) mediante 'super'.
     *
     * @param driver Instancia del AndroidDriver inyectada desde la prueba.
     */
    public SwipePage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Valida si la pantalla de Swipe está visible en el emulador.
     *
     * @return true si el contenedor principal está visible, false en caso contrario.
     */
    public boolean isSwipeScreenVisible() {
        return isElementVisible(swipeScreen);
    }
}