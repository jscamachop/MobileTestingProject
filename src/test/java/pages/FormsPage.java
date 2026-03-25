package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object que representa la pantalla de Formularios (Forms).
 * Hereda de BasePage para reutilizar la instancia del driver y mantener un código limpio.
 */
public class FormsPage extends BasePage {

    /** Localizador del contenedor principal de la pantalla Forms. */
    private By formsScreen = AppiumBy.accessibilityId("Forms-screen");

    /**
     * Constructor de la clase FormsPage.
     * Llama al constructor de la clase padre (BasePage) mediante 'super'.
     *
     * @param driver Instancia del AndroidDriver inyectada desde la prueba.
     */
    public FormsPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Valida si la pantalla de Formularios está visible en el emulador.
     *
     * @return true si el contenedor principal está visible, false en caso contrario.
     */
    public boolean isFormsScreenVisible() {
        return isElementVisible(formsScreen);
    }
}