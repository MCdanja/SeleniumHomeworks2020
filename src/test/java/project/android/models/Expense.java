package project.android.models;

import project.functions.CommonFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

import static project.functions.CommonFunctions.getConfigValue;

public class Expense {

    private String title;
    private int sum;
    private String date;
    private String category;

    public Expense() {
        title = CommonFunctions.getRandomString(10);
        Integer bound = new Integer(getConfigValue("max_expense_sum"));
        sum = CommonFunctions.getRandomPositiveNumber(bound);
        String datePattern = "dd/MM/yyyy";
        date = new SimpleDateFormat(datePattern).format(new Date());
        category = CommonFunctions.getRandomString(10);
    }

    public Expense(String title, int sum, String date, String category) {
        this.title = title;
        this.sum = sum;
        this.date = date;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public int getSum() {
        return sum;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }
}
