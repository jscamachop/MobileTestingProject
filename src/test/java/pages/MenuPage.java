package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase que representa el menú de navegación inferior.
 */
public class MenuPage extends BasePage {


    private By btnHome = AppiumBy.accessibilityId("Home");
    private By btnWebview = AppiumBy.accessibilityId("Webview");
    private By btnLogin = AppiumBy.accessibilityId("Login");
    private By btnForms = AppiumBy.accessibilityId("Forms");
    private By btnSwipe = AppiumBy.accessibilityId("Swipe");
    private By btnDrag = AppiumBy.accessibilityId("Drag");

    private By btnMenu = AppiumBy.xpath("//*[@content-desc='Menu'] | //*[@text='Menu']/..");

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    // --- Métodos de Acción ---

    public void tapOnHome() { clickElement(btnHome); }
    public void tapOnWebview() { clickElement(btnWebview); }
    public void tapOnLogin() { clickElement(btnLogin); }
    public void tapOnForms() { clickElement(btnForms); }
    public void tapOnSwipe() { clickElement(btnSwipe); }
    public void tapOnDrag() { clickElement(btnDrag); }
    public void tapOnMenu() { clickElement(btnMenu); }
}