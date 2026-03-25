package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.SignUpPage;

/**
 * Clase de prueba para validar el flujo de inicio de sesión (Login) en la aplicación.
 * <p>
 * Implementa la mejor práctica de "Data Independence" (Independencia de Datos),
 * creando un usuario al vuelo como precondición antes de intentar iniciar sesión
 * con esas mismas credenciales.
 */
public class LoginTest extends BaseTest {

    /**
     * Prueba End-to-End que primero registra un usuario nuevo dinámico y luego
     * utiliza esas credenciales recién creadas para iniciar sesión, validando
     * finalmente que aparezca la alerta de éxito correspondiente al Login.
     */
    @Test
    public void testSuccessfulLogin() {
        MenuPage menuPage = new MenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        // Generamos credenciales únicas para todo el flujo
        String uniqueEmail = "usuario" + System.currentTimeMillis() + "@gmail.com";
        String validPassword = "Password123!";

        System.out.println("1. Preparando datos: Creando usuario nuevo...");
        menuPage.tapOnLogin();

        signUpPage.goToSignUpTab();
        signUpPage.enterEmail(uniqueEmail);
        signUpPage.enterPassword(validPassword);
        signUpPage.enterRepeatPassword(validPassword);
        signUpPage.clickSignUpSubmitButton();

        // Validamos la creación exitosa y cerramos la alerta
        Assert.assertEquals(signUpPage.getAlertTitleText(), "Signed Up!", "Error en la precondición: No se pudo crear el usuario.");
        signUpPage.acceptAlert();

        System.out.println("2. Iniciando test: Cambiando a pestaña Login...");
        loginPage.goToLoginTab();

        System.out.println("3. Ingresando credenciales recién creadas...");
        loginPage.enterEmail(uniqueEmail);
        loginPage.enterPassword(validPassword);

        System.out.println("4. Haciendo clic en Login...");
        loginPage.clickLoginButton();

        System.out.println("5. Verificando éxito (Alerta 'Success')...");
        // Validamos que el pop-up ahora indique éxito en el Login
        Assert.assertEquals(loginPage.getAlertTitleText(), "Success", "Error: El Login no fue exitoso.");

        // Cerramos el pop-up nativo
        loginPage.acceptAlert();
        System.out.println("Prueba de Login completa");
    }
}