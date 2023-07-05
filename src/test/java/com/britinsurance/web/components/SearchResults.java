package com.britinsurance.web.components;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class SearchResults {
  public static final Target RESULTS_HEADER = Target.the("Results header").located(By.xpath("//h2['results'=text()]"));
  public static final Target RESULT_LINK = Target.the("Result link").located(By.xpath("//a[@class='s-results__tag']"));

  public static Question<List<String>> returnedResultsLinkTexts() {
    return actor -> BrowseTheWeb.as(actor).findAll(RESULT_LINK.waitingForNoMoreThan(Duration.ofSeconds(5))).texts();
  }
}
