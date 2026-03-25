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
        // Creamos la regla de espera explícita (máximo 10 segundos)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // --- Métodos Reutilizables para todas las páginas ---

    /**
     * Método genérico que usa Espera Explícita para verificar si un elemento es visible.
     * Atrapa el error si el tiempo se agota, devolviendo un 'false' limpio
     * ideal para usar con Asserts, evitando que el código explote bruscamente.
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
     * Se asegura de que el elemento no solo exista, sino que sea "clickeable".
     *
     * @param locator El localizador (By) del elemento a clickear.
     */
    protected void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}