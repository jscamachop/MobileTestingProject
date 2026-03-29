package tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

/**
 * Clase de prueba para validar el correcto funcionamiento de la navegación
 * a través del menú inferior de la aplicación.
 */
public class NavigationTest extends BaseTest {

    @Test
    public void testBottomNavigationAndAsserts() {
        BasePage basePage = new BasePage(driver);
        MenuPage menuPage = new MenuPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        FormsPage formsPage = new FormsPage(driver);
        SwipePage swipePage = new SwipePage(driver);
        DragPage dragPage = new DragPage(driver);
        WebviewPage webviewPage = new WebviewPage(driver);
        MenuDrawerPage menuDrawerPage = new MenuDrawerPage(driver);

        System.out.println("Navegando a Webview...");
        menuPage.tapOnWebview();
        Assert.assertTrue(webviewPage.isWebviewScreenVisible(), "Error: La pantalla de Webview no reaccionó.");


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

        System.out.println("Navegando a la sección Drag...");
        menuPage.tapOnDrag();
        Assert.assertTrue(dragPage.isDragScreenVisible(), "Error: No se cargó la pantalla Drag.");

        System.out.println("Abriendo el Menú lateral derecho...");
        menuPage.tapOnMenu();
        Assert.assertTrue(menuDrawerPage.isMenuDrawerVisible(), "Error: El menú lateral no se desplegó.");


        System.out.println("Prueba de navegación completada");
    }
}