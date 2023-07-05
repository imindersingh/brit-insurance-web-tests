package com.britinsurance.web.components;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class Menu {
  public static final Target MENU_BUTTON = Target.the("Mega menu button")
                                                 .located(By.xpath("//button[@data-trigger='mega-menu']"));
  public static final Target CONTACT_LINK = Target.the("Mega menu - contact link").located(By.xpath("//a[@href='/contact']"));
}
