package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase que representa la pantalla de Webview.
 */
public class WebviewPage extends BasePage {

    private By webviewScreen = AppiumBy.accessibilityId("Webview-screen");

    private By loadingIndicator = AppiumBy.xpath("//*[contains(@text, 'Loading') or contains(@content-desc, 'loading')]");

    public WebviewPage(AndroidDriver driver) {
        super(driver);
    }

    /** * Valida la pantalla buscando el contenedor nativo..
     */
    public boolean isWebviewScreenVisible() {
        return isElementVisible(webviewScreen);
    }

    /**
     * Verifica si el botón/texto de "Loading" está en pantalla.
     */
    public boolean isLoadingVisibleFast() {
        return isElementPresentFast(loadingIndicator);
    }
}