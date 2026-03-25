package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

/**
 * Clase de prueba para validar el flujo de registro (Sign Up).
 * Cumple con el principio de idempotencia generando datos dinámicos.
 */
public class SignUpTest extends BaseTest {

    /**
     * Prueba que valida un registro exitoso ingresando credenciales válidas
     * y generando un correo único para evitar dependencias de ejecuciones previas.
     */
    @Test
    public void testSuccessfulSignUp() {
        MenuPage menuPage = new MenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Generamos un email único basado en el tiempo actual en milisegundos (Idempotencia)
        String uniqueEmail = "qatest" + System.currentTimeMillis() + "@gmail.com";
        String validPassword = "Password123!"; //posible mejora

        System.out.println("1. Cumpliendo precondición: Navegando a la sección de Login...");
        menuPage.tapOnLogin();
        Assert.assertTrue(loginPage.isLoginScreenVisible(), "Error: No se llegó a la pantalla inicial.");

        System.out.println("2. Navegando a la pestaña de Sign Up...");
        loginPage.goToSignUpTab();

        System.out.println("3. Llenando el formulario con email único: " + uniqueEmail);
        loginPage.enterEmail(uniqueEmail);
        loginPage.enterPassword(validPassword);
        loginPage.enterRepeatPassword(validPassword);

        System.out.println("4. Haciendo clic en el botón de registrarse...");
        loginPage.clickSignUpSubmitButton();

        System.out.println("5. Verificando que el proceso fue exitoso...");
        // Validamos que el pop-up que sale diga "Signed Up!"
        String actualAlertTitle = loginPage.getAlertTitleText();
        Assert.assertEquals(actualAlertTitle, "Signed Up!", "Error: El registro no fue exitoso o el mensaje cambió.");

        // Cerramos el pop-up para dejar la app limpia
        loginPage.acceptAlert();
        System.out.println("Prueba de Sign Up superada con éxito");
    }
}