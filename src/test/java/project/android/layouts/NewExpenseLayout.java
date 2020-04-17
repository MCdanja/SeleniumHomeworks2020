package project.android.layouts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.android.models.Expense;

import java.time.Duration;

public class NewExpenseLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_title_edit")
    private MobileElement expenseTitle;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_sum_edit")
    private MobileElement expenseSum;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_date_edit")
    private MobileElement expenseDate;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_category_picker")
    private MobileElement expenseCategory;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/save_new_expense")
    private MobileElement expenseSaveButton;


    private static final String ACTIVITY_NAME = "NewExpenseActivity";

    public NewExpenseLayout(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public String getActivityName() {
        return ACTIVITY_NAME;
    }

    public void createNewExpense(Expense expense) {
        enterTitle(expense.getTitle());
        enterSum(Integer.toString(expense.getSum()));
        enterDate(expense.getDate());
        enterCategory(expense.getCategory());
        clickSave();
    }

    private void enterTitle(String title) {
        expenseTitle.sendKeys(title);
    }

    private void enterSum(String sum) {
        expenseSum.sendKeys(sum);
    }

    private void enterDate(String date) {
        expenseDate.sendKeys(date);
    }

    private void enterCategory(String category) {
        expenseCategory.sendKeys(category);
    }

    private void clickSave() {
        expenseSaveButton.click();
    }
}
