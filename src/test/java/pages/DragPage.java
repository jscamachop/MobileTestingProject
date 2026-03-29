package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object que representa la pantalla de Drag and Drop.
 */
public class DragPage extends BasePage {

    private By dragScreenTitle = AppiumBy.xpath("//*[@text='Drag and Drop']");

    public DragPage(AndroidDriver driver) {
        super(driver);
    }

    /** Verifica si el título de la pantalla Drag está visible. */
    public boolean isDragScreenVisible() {
        return isElementVisible(dragScreenTitle);
    }
}