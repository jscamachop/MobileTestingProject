package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object que representa el menú lateral desplegable (Drawer).
 */
public class MenuDrawerPage extends BasePage {

    private By menuOptionPermissions = AppiumBy.xpath("//*[contains(@text, 'Permissions') or contains(@content-desc, 'Permissions')]");

    public MenuDrawerPage(AndroidDriver driver) {
        super(driver);
    }

    /** Verifica si las opciones del menú lateral están visibles. */
    public boolean isMenuDrawerVisible() {
        return isElementVisible(menuOptionPermissions);
    }
}