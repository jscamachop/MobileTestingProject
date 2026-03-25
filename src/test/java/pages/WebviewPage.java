package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object que representa la pantalla de Webview.
 * Hereda de BasePage para reutilizar la instancia del driver.
 */
public class WebviewPage extends BasePage {

    /** Localizador del contenedor principal de la pantalla Webview. */
    private By webviewScreen = AppiumBy.accessibilityId("Webview-screen");

    /**
     * Constructor de la clase WebviewPage.
     * Llama al constructor de la clase padre (BasePage).
     *
     * @param driver Instancia del AndroidDriver inyectada desde la prueba.
     */
    public WebviewPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Valida si la pantalla de Webview está visible en el emulador.
     * <p>
     * Nota: Dependiendo de la configuración de internet del emulador,
     * el contenido interno podría quedarse en estado de "Loading",
     * pero el contenedor principal (Webview-screen) sí debería aparecer.
     *
     * @return true si el contenedor principal está visible, false en caso contrario.
     */
    public boolean isWebviewScreenVisible() {
        return isElementVisible(webviewScreen);
    }
}