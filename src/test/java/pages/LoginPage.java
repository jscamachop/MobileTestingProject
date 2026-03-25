package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object que representa la sección de Autenticación (Login y Sign Up).
 * Hereda de BasePage para utilizar esperas explícitas seguras.
 */
public class LoginPage extends BasePage {

    // --- Localizadores de Login ---
    private By loginScreen = AppiumBy.accessibilityId("Login-screen");
    private By inputEmail = AppiumBy.accessibilityId("input-email");
    private By inputPassword = AppiumBy.accessibilityId("input-password");
    private By btnLoginSubmit = AppiumBy.accessibilityId("button-LOGIN");

    // --- Localizadores de Sign Up ---
    private By tabSignUp = AppiumBy.accessibilityId("button-sign-up-container");
    private By inputRepeatPassword = AppiumBy.accessibilityId("input-repeat-password");
    private By btnSignUpSubmit = AppiumBy.accessibilityId("button-SIGN UP");

    // --- Localizadores del Pop-up
    private By alertTitle = AppiumBy.xpath("//android.widget.TextView[@text='Signed Up!']");
    private By alertOkButton = AppiumBy.xpath("//android.widget.Button[@text='OK']");

    /**
     * Constructor de la clase LoginPage.
     *
     * @param driver Instancia del AndroidDriver inyectada desde la prueba.
     */
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    // --- Métodos de Validación Inicial ---

    /** Valida si la pantalla de Login está visible. */
    public boolean isLoginScreenVisible() {
        return isElementVisible(loginScreen);
    }

    /** Valida si el botón de hacer submit en el Login está habilitado. */
    public boolean isLoginButtonEnabled() {
        if (isElementVisible(btnLoginSubmit)) {
            return driver.findElement(btnLoginSubmit).isEnabled();
        }
        return false;
    }


    /** Hace clic en la pestaña "Sign up" en la parte superior de la pantalla. */
    public void goToSignUpTab() {
        clickElement(tabSignUp);
    }

    // --- Métodos de Acción: Formularios ---

    /** Ingresa el correo electrónico. */
    public void enterEmail(String email) {
        typeText(inputEmail, email);
    }

    /** Ingresa la contraseña. */
    public void enterPassword(String password) {
        typeText(inputPassword, password);
    }

    /** Ingresa la confirmación de la contraseña (solo para Sign Up). */
    public void enterRepeatPassword(String password) {
        typeText(inputRepeatPassword, password);
    }

    /** Hace clic en el botón principal de Login. */
    public void clickLoginButton() {
        clickElement(btnLoginSubmit);
    }

    /** Hace clic en el botón principal de Sign Up. */
    public void clickSignUpSubmitButton() {
        clickElement(btnSignUpSubmit);
    }

    /** * Obtiene el título de la alerta nativa de Android que aparece al tener éxito.
     * @return El texto del título de la alerta.
     */
    public String getAlertTitleText() {
        return getText(alertTitle);
    }

    /** Hace clic en el botón OK de la alerta nativa para cerrarla. */
    public void acceptAlert() {
        clickElement(alertOkButton);
    }
}