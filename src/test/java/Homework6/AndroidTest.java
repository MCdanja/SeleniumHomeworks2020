package Homework6;

import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import project.android.*;
import project.android.layouts.BudgetLayout;
import project.android.layouts.LoginLayout;
import project.android.layouts.NewExpenseLayout;
import project.android.layouts.RegisterLayout;
import project.android.models.Expense;
import project.android.models.User;

import java.util.concurrent.TimeUnit;

public class AndroidTest {

    private static AndroidDriverManager driverManager;
    private static AndroidDriver driver;
    private LoginLayout loginLayout;
    private RegisterLayout registerLayout;
    private BudgetLayout budgetLayout;
    private NewExpenseLayout newExpenseLayout;

    @BeforeClass
    public static void prepareTest() {
        driverManager = new AndroidDriverManager();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Before
    public void startApp() {
        driver.launchApp();
        loginLayout = new LoginLayout(driver);
        registerLayout = new RegisterLayout(driver);
        budgetLayout = new BudgetLayout(driver);
        newExpenseLayout = new NewExpenseLayout(driver);
    }

    @Test
    public void testRegister() {
        User user = new User();
        loginLayout.clickRegisterBtn();
        registerLayout.registerNewUser(user);
        Assert.assertTrue(driver.currentActivity().contains(loginLayout.getActivityName()));
    }

    @Test
    public void testLogin() {
        User user = new User();
        loginLayout.clickRegisterBtn();
        registerLayout.registerNewUser(user);

        loginLayout.login(user);
        Assert.assertTrue(driver.currentActivity().contains(budgetLayout.getActivityName()));
    }

    @Test
    public void testAddExpense() {
        User user = new User();
        loginLayout.clickRegisterBtn();
        registerLayout.registerNewUser(user);
        loginLayout.login(user);

        Expense expense = new Expense();
        budgetLayout.clickAddExpense();
        Assert.assertTrue(driver.currentActivity().contains(newExpenseLayout.getActivityName()));
        newExpenseLayout.createNewExpense(expense);
        Assert.assertTrue(budgetLayout.containsExpense(expense));
    }

    @After
    public void closeApp() {
        driver.closeApp();
    }

    @AfterClass
    public static void quit() {
        driverManager.quitDriver();
    }
}
