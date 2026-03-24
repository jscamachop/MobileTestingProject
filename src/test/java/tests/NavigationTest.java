package tests;

import org.testng.annotations.Test;

/**
 * Clase de prueba para verificar la navegación principal dentro de la aplicación.
 * Hereda la configuración y el ciclo de vida del driver de la clase {@link BaseTest}.
 */
public class NavigationTest extends BaseTest {

    /**
     * Prueba de humo (smoke test) para confirmar que la configuración inicial
     * es correcta y que la aplicación logra abrirse en el emulador.
     * <p>
     * Nota temporal: Contiene una pausa explícita con fines de validación visual.
     *
     * @throws InterruptedException Si el hilo en pausa es interrumpido.
     */
    @Test
    public void testAppOpens() throws InterruptedException {
        System.out.println("¡Éxito! Appium abrió la aplicación en el emulador.");

        Thread.sleep(5000);
    }
}