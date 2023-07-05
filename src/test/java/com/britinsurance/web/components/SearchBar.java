package com.britinsurance.web.components;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class SearchBar {
  public static final Target SEARCH_INPUT = Target.the("Search input field")
                                                  .located(By.xpath("//input[@type='search']"));
  public static final Target SEARCH_BUTTON = Target.the("Search button")
                                                   .located(By.xpath("//button[@type='button']"));
}
