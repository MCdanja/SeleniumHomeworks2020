package project.android.layouts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.android.models.Expense;

import java.time.Duration;
import java.util.List;

public class BudgetLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    private MobileElement addExpenseButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/expense_title")
    private List<MobileElement> expensesTitle;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/expense_category")
    private List<MobileElement> expensesCategory;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/expense_sum")
    private List<MobileElement> expensesSum;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/expense_date")
    private List<MobileElement> expensesDate;


    private static final String ACTIVITY_NAME = "BudgetActivity";

    public BudgetLayout(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public String getActivityName() {
        return ACTIVITY_NAME;
    }

    public void clickAddExpense() {
        addExpenseButton.click();
    }

    public boolean containsExpense(Expense expense) {
        for (int i = 0; i < expensesTitle.size(); i++) {
            if (expensesTitle.get(i).getText().equals(expense.getTitle()) &&
                    expensesSum.get(i).getText().equals(expense.getSum() + "$") &&
                    expensesDate.get(i).getText().equals(expense.getDate()) &&
                    expensesCategory.get(i).getText().equals(expense.getCategory())) {
                return true;
            }
        }
        return false;
    }
}
