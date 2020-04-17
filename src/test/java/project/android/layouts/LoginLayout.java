package project.android.layouts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.android.models.User;

import java.time.Duration;

public class LoginLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private MobileElement loginEmail;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private MobileElement loginPassword;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private MobileElement signInButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private MobileElement registerButton;

    private static final String ACTIVITY_NAME = "LoginActivity";

    public LoginLayout(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public void login(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickSignInBtn();
    }

    private void enterEmail(String email) {
        loginEmail.sendKeys(email);
    }

    private void enterPassword(String password) {
        loginPassword.sendKeys(password);
    }

    private void clickSignInBtn() {
        signInButton.click();
    }

    public void clickRegisterBtn() {
        registerButton.click();
    }

    public String getActivityName() {
        return ACTIVITY_NAME;
    }

}
