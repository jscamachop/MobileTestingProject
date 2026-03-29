package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.SignUpPage;

/**
 * Clase de prueba para validar el flujo de registro (Sign Up).
 * Utiliza datos dinámicos para evitar fallos por usuarios duplicados.
 */
public class SignUpTest extends BaseTest {

    @Test
    public void testSuccessfulSignUp() {
        MenuPage menuPage = new MenuPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        String uniqueEmail = "usuario" + System.currentTimeMillis() + "@gmail.com";
        String validPassword = "Password123!";

        System.out.println("1. Navegando a la sección de autenticación...");
        menuPage.tapOnLogin();

        System.out.println("2. Navegando a la pestaña de Sign Up...");
        signUpPage.goToSignUpTab();

        System.out.println("3. Llenando el formulario con email único: " + uniqueEmail);
        signUpPage.enterEmail(uniqueEmail);
        signUpPage.enterPassword(validPassword);
        signUpPage.enterRepeatPassword(validPassword);

        System.out.println("4. Haciendo clic en registrarse...");
        signUpPage.clickSignUpSubmitButton();

        System.out.println("5. Verificando éxito (Alerta 'Signed Up!')...");
        Assert.assertEquals(signUpPage.getAlertTitleText(), "Signed Up!", "Error: El registro falló.");

        signUpPage.acceptAlert();
        System.out.println("Prueba de Sign Up completa");
    }
}