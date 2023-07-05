package com.britinsurance.web.components;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class SearchBar {
  public static final Target SEARCH_INPUT = Target.the("Search input field")
                                                  .located(By.xpath("//input[@data-component-id='8e5fbbf3-eba0-496c-a1d4-c0b34301eaf4']"));
  public static final Target SEARCH_BUTTON = Target.the("Search button")
                                                   .located(By.xpath("//button[@type='button']"));
}
