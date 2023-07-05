package com.britinsurance.web.components;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class ContactDetails {
  public static final Target BERMUDA_ADDRESS = Target.the("Bermuda office address")
                                                     .located(By.xpath("//div[@id='bermudaoffice']//address"));

  public static Question<String> officeAddress(final Target target) {
    return actor -> target.resolveFor(actor).getText();
  }
}
