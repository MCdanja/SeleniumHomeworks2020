package project.pages.google;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GoogleResultPage extends Form {
    
    private final static String PAGE_LOC = "//*[contains(@id,'result')]";
    
    private ILabel firstResultLbl = getElementFactory().getLabel(By.xpath("(//h3)[1]"), "First result");
    
    public GoogleResultPage() {
        super(By.xpath(PAGE_LOC), "Google result page");
    }
    
    public boolean isFirstResultContains(String text) {
        return firstResultLbl.getText().contains(text);
    }
}
