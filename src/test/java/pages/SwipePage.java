package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase que representa la pantalla de Swipe.
 */
public class SwipePage extends BasePage {


    private By swipeScreen = AppiumBy.accessibilityId("Swipe-screen");


    private By firstCard = AppiumBy.xpath("//*[@text='FULLY OPEN SOURCE']");
    private By lastCard = AppiumBy.xpath("//*[@text='COMPATIBLE']");

    private By hiddenText = AppiumBy.xpath("//*[@text='You found me!!!']");

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

    public void swipeToNextCard() {
        swipeLeft();
    }

    public void scrollToHiddenText() {
        scrollDownFromTop();

        int maxScrolls = 5;
        while (!isElementPresentFast(hiddenText) && maxScrolls > 0) {
            scrollDownFromBottom();
            maxScrolls--;
        }
    }


    public boolean isFirstCardHidden() {
        return isElementHidden(firstCard);
    }

    public boolean isLastCardVisible() {
        return isElementVisible(lastCard);
    }

    public boolean isHiddenTextVisible() {
        return isElementVisible(hiddenText);
    }
}