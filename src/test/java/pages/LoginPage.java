package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object exclusiva para el flujo de Inicio de Sesión (Login).
 */
public class LoginPage extends BasePage {

    //Localizadores exclusivos
    private By loginScreen = AppiumBy.accessibilityId("Login-screen");
    private By tabLogin = AppiumBy.accessibilityId("button-login-container");
    private By inputEmail = AppiumBy.accessibilityId("input-email");
    private By inputPassword = AppiumBy.accessibilityId("input-password");
    private By btnLoginSubmit = AppiumBy.accessibilityId("button-LOGIN");

    //Localizadores de Alertas
    private By alertTitle = AppiumBy.xpath("//*[@text='Success']");
    private By alertOkButton = AppiumBy.xpath("//*[@text='OK']");

    public LoginPage(AndroidDriver driver) { super(driver); }

    //Métodos de Validación
    public boolean isLoginScreenVisible() { return isElementVisible(loginScreen); }

    /** * Valida si el botón de Login está habilitado (Requerido por NavigationTest).
     */
    public boolean isLoginButtonEnabled() {
        if (isElementVisible(btnLoginSubmit)) {
            return driver.findElement(btnLoginSubmit).isEnabled();
        }
        return false;
    }

    //Métodos de Acción
    public void goToLoginTab() { clickElement(tabLogin); }
    public void enterEmail(String email) { typeText(inputEmail, email); }
    public void enterPassword(String password) { typeText(inputPassword, password); }
    public void clickLoginButton() { clickElement(btnLoginSubmit); }

    //Métodos de Alertas
    public String getAlertTitleText() { return getText(alertTitle); }
    public void acceptAlert() { clickElement(alertOkButton); }
}