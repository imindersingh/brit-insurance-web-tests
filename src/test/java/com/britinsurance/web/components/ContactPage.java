package com.britinsurance.web.components;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.britinsurance.com/contact")
public class ContactPage extends PageObject {
    public static final Target BERMUDA_ADDRESS = Target.the("Bermuda office address")
            .located(By.xpath("//div[@id='bermudaoffice']//address"));

    public static Question<String> officeAddress(final Target target) {
        return actor -> target.resolveFor(actor).getText();
    }
}
