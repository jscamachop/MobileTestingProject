package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.SignUpPage;

/**
 * Clase de prueba para validar el flujo de inicio de sesión (Login).
 * Separa limpiamente las precondiciones (@BeforeMethod) de la prueba real (@Test).
 */
public class LoginTest extends BaseTest {

    // Variables a nivel de clase para compartir datos entre el Setup y el Test
    private LoginPage loginPage;
    private String uniqueEmail;
    private String validPassword;

    /**
     * PRECONDICIÓN: Se ejecuta DESPUÉS de abrir la app (BaseTest) pero ANTES del test.
     * Aquí creamos el usuario dinámico para cumplir con la "Data Independence".
     */
    @BeforeMethod
    public void setupLoginPrecondition() {
        MenuPage menuPage = new MenuPage(driver);
        loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        uniqueEmail = "usuario" + System.currentTimeMillis() + "@gmail.com";
        validPassword = "Password123!";

        System.out.println("--- @BeforeMethod: Preparando datos y creando usuario ---");
        menuPage.tapOnLogin();
        signUpPage.goToSignUpTab();
        signUpPage.enterEmail(uniqueEmail);
        signUpPage.enterPassword(validPassword);
        signUpPage.enterRepeatPassword(validPassword);
        signUpPage.clickSignUpSubmitButton();

        // Asumimos que la creación es exitosa y cerramos la alerta para limpiar la pantalla
        signUpPage.acceptAlert();
    }

    /**
     * evaluamos la funcionalidad de Login.
     */
    @Test
    public void testSuccessfulLogin() {
        System.out.println("--- @Test: Iniciando prueba de Login ---");

        System.out.println("1. Cambiando a pestaña Login...");
        loginPage.goToLoginTab();

        System.out.println("2. Ingresando credenciales recién creadas...");
        loginPage.enterEmail(uniqueEmail);
        loginPage.enterPassword(validPassword);

        System.out.println("3. Haciendo clic en Login...");
        loginPage.clickLoginButton();

        System.out.println("4. Verificando éxito (Alerta 'Success')...");
        Assert.assertEquals(loginPage.getAlertTitleText(), "Success", "Error: El Login no fue exitoso.");

        loginPage.acceptAlert();
        System.out.println("Prueba de Login completa");
    }
}