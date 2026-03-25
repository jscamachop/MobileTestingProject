package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.SignUpPage;

/**
 * Clase de prueba para validar el flujo de registro (Sign Up) en la aplicación.
 * <p>
 * Esta clase asegura que un usuario nuevo pueda crearse exitosamente utilizando
 * el principio de idempotencia (generación de datos dinámicos) para evitar
 * fallos por dependencias de ejecuciones anteriores en la base de datos.
 */
public class SignUpTest extends BaseTest {

    /**
     * Prueba End-to-End que navega a la sección de autenticación, completa el
     * formulario de registro con un correo electrónico único y valida que
     * la alerta de éxito nativa de Android se muestre y cierre correctamente.
     */
    @Test
    public void testSuccessfulSignUp() {
        MenuPage menuPage = new MenuPage(driver);
        LoginPage loginPage = new LoginPage(driver); // Solo para validar la precondición inicial
        SignUpPage signUpPage = new SignUpPage(driver);

        // Generamos un email único basado en el tiempo actual en milisegundos
        String uniqueEmail = "usuario" + System.currentTimeMillis() + "@gmail.com";
        String validPassword = "Password123!";

        System.out.println("1. Navegando a la sección de autenticación...");
        menuPage.tapOnLogin();

        // Validación de la precondición
        Assert.assertTrue(loginPage.isLoginScreenVisible(), "Error: No se llegó a la pantalla inicial.");

        System.out.println("2. Navegando a la pestaña de Sign Up...");
        signUpPage.goToSignUpTab();

        System.out.println("3. Llenando el formulario con email único: " + uniqueEmail);
        signUpPage.enterEmail(uniqueEmail);
        signUpPage.enterPassword(validPassword);
        signUpPage.enterRepeatPassword(validPassword);

        System.out.println("4. Haciendo clic en registrarse...");
        signUpPage.clickSignUpSubmitButton();

        System.out.println("5. Verificando éxito (Alerta 'Signed Up!')...");
        // Comprobamos que el texto de la alerta extraído mediante XPath coincida
        Assert.assertEquals(signUpPage.getAlertTitleText(), "Signed Up!", "Error: El registro falló o la alerta es incorrecta.");

        // Cerramos el pop-up para dejar la aplicación en un estado limpio
        signUpPage.acceptAlert();
        System.out.println("Prueba de Sign Up completa");
    }
}