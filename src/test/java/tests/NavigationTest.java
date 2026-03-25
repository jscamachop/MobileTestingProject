package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.SwipePage;
import pages.WebviewPage;

/**
 * Clase de prueba para validar el correcto funcionamiento de la navegación
 * a través del menú inferior de la aplicación, comprobando la visibilidad
 * y propiedades de los elementos esperados en cada pantalla.
 */
public class NavigationTest extends BaseTest {

    /**
     * Prueba End-to-End que navega por las secciones principales y
     * realiza aserciones (Asserts) para garantizar que las páginas cargan
     * correctamente y los elementos están visibles/habilitados.
     */
    @Test
    public void testBottomNavigationAndAsserts() {
        // 1. Inicializamos nuestros Page Objects pasándoles el driver
        WebviewPage webviewPage = new WebviewPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        FormsPage formsPage = new FormsPage(driver);
        SwipePage swipePage = new SwipePage(driver);


        /**
        System.out.println("Navegando a Webview...");
        menuPage.tapOnWebview();
        Assert.assertTrue(webviewPage.isWebviewScreenVisible(), "Error: La pantalla de Webview no está visible.");
         */

        System.out.println("Navegando a Login...");
        menuPage.tapOnLogin();
        Assert.assertTrue(loginPage.isLoginScreenVisible(), "Error: La pantalla de Login no está visible.");
        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Error: El botón de Login no está habilitado.");

        System.out.println("Navegando a Forms...");
        menuPage.tapOnForms();
        Assert.assertTrue(formsPage.isFormsScreenVisible(), "Error: La pantalla de Forms no está visible.");

        System.out.println("Navegando a Swipe...");
        menuPage.tapOnSwipe();
        Assert.assertTrue(swipePage.isSwipeScreenVisible(), "Error: La pantalla de Swipe no está visible.");

        System.out.println("Navegando de vuelta a Home...");
        menuPage.tapOnHome();
        Assert.assertTrue(homePage.isHomeVisible(), "Error: La pantalla de Home no está visible al regresar.");

        System.out.println("¡Prueba completada con éxito! Todas las aserciones pasaron.");
    }
}