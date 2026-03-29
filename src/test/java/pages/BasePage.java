package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.util.Collections;
import io.appium.java_client.AppiumBy;
import java.time.Duration;

/**
 * Clase base arquitectónica para todos los Page Objects.
 * Centraliza el driver y proporciona métodos de interacción robustos
 * utilizando Esperas Explícitas (Explicit Waits).
 */
public class BasePage {

    protected AndroidDriver driver;

    /** Objeto WebDriverWait para manejar las esperas explícitas. */
    protected WebDriverWait wait;

    /**
     * Constructor de la clase BasePage.
     * Inicializa el driver y configura una espera explícita global de 10 segundos.
     *
     * @param driver Instancia del AndroidDriver inyectada desde la prueba.
     */
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    /**
     * Método genérico que usa Espera Explícita para verificar si un elemento es visible.
     *
     * @param locator El localizador (By) del elemento a buscar.
     * @return true si el elemento se hace visible a tiempo, false si se agota el tiempo.
     */
    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Método genérico que usa Espera Explícita para hacer clic.
     *
     * @param locator El localizador (By) del elemento a clickear.
     */
    protected void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Método genérico que usa Espera Explícita para escribir texto en un campo.
     * Limpia el campo antes de escribir para evitar errores.
     *
     * @param locator El localizador (By) del campo de texto.
     * @param text El texto que se desea ingresar.
     */
    protected void typeText(By locator, String text) {
        var element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Método genérico que usa Espera Explícita para obtener el texto de un elemento.
     *
     * @param locator El localizador (By) del elemento.
     * @return El texto visible del elemento.
     */
    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected void swipeLeft() {
        var size = driver.manage().window().getSize();

        // Empezamos casi al borde derecho (90%) y terminamos casi al borde izquierdo (5%)
        int startX = (int) (size.width * 0.94);
        int endX = (int) (size.width * 0.04);
        int startY = size.height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Pausa inicial para "clavar" el dedo
        swipe.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(300)));

        // Aumentamos la duración a 1500ms para que el arrastre sea lento y seguro
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), endX, startY));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    /**
     * Método genérico y reutilizable para hacer scroll vertical indicando los porcentajes.
     * @param startPercentage Porcentaje de la pantalla donde inicia el dedo (ej. 0.80)
     * @param endPercentage Porcentaje de la pantalla donde termina el dedo (ej. 0.20)
     */
    protected void swipeVertical(double startPercentage, double endPercentage) {
        var size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * startPercentage);
        int endY = (int) (size.height * endPercentage);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(300)));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));
    }

    /**
     * Scroll desde la zona blanca superior (ideal para el primer empujón).
     */
    protected void scrollDownFromTop() {
        swipeVertical(0.35, 0.10);
    }

    /**
     * Scroll desde la zona blanca inferior (evitando el menú que está en el 90-100%).
     */
    protected void scrollDownFromBottom() {
        swipeVertical(0.80, 0.50);
    }

    /**
     * Verifica si un elemento NO es visible (devuelve true si está oculto).
     */
    protected boolean isElementHidden(By locator) {
        return !isElementVisible(locator);
    }

    /**
     * Verifica rápidamente si un elemento existe en el DOM sin esperar.
     */
    protected boolean isElementPresentFast(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}