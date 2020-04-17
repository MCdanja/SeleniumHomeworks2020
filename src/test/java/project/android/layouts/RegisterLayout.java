package project.android.layouts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.android.models.User;

import java.time.Duration;

public class RegisterLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private MobileElement registerEmail;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private MobileElement registerUserName;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private MobileElement registerPassword;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private MobileElement registerConfirmPassword;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private MobileElement registerButton;

    public RegisterLayout(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public void registerNewUser(User user) {
        enterEmail(user.getEmail());
        enterUserName(user.getUserName());
        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
        clickRegisterButton();
    }

    private void enterEmail(String email) {
        registerEmail.sendKeys(email);
    }

    private void enterUserName(String userName) {
        registerUserName.sendKeys(userName);
    }

    private void enterPassword(String password) {
        registerPassword.sendKeys(password);
    }

    private void enterConfirmPassword(String password) {
        registerConfirmPassword.sendKeys(password);
    }

    private void clickRegisterButton() {
        registerButton.click();
    }

}
