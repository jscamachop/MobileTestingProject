package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Clase Page Object exclusiva para el flujo de Registro (Sign Up).
 */
public class SignUpPage extends BasePage {

    //Localizadores exclusivos
    private By tabSignUp = AppiumBy.accessibilityId("button-sign-up-container");
    private By inputEmail = AppiumBy.accessibilityId("input-email");
    private By inputPassword = AppiumBy.accessibilityId("input-password");
    private By inputRepeatPassword = AppiumBy.accessibilityId("input-repeat-password");
    private By btnSignUpSubmit = AppiumBy.accessibilityId("button-SIGN UP");

    //Localizadores de Alertas
    private By alertTitle = AppiumBy.xpath("//*[@text='Signed Up!']");
    private By alertOkButton = AppiumBy.xpath("//*[@text='OK']");

    public SignUpPage(AndroidDriver driver) { super(driver); }

    public void goToSignUpTab() { clickElement(tabSignUp); }
    public void enterEmail(String email) { typeText(inputEmail, email); }
    public void enterPassword(String password) { typeText(inputPassword, password); }
    public void enterRepeatPassword(String password) { typeText(inputRepeatPassword, password); }
    public void clickSignUpSubmitButton() { clickElement(btnSignUpSubmit); }

    public String getAlertTitleText() { return getText(alertTitle); }
    public void acceptAlert() { clickElement(alertOkButton); }
}