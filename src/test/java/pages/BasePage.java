package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    // --- Métodos Reutilizables para todas las páginas ---

    /**
     * Método genérico que usa Espera Explícita para verificar si un elemento es visible.
     *
     * @param locator El localizador (By) del elemento a buscar.
     * @return true si el elemento se hace visible a tiempo, false si se agota el tiempo.
     */
    protected boolean isElementVisible(By locator) {
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
}