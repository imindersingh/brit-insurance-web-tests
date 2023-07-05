package com.britinsurance.web.actions;

import com.britinsurance.web.components.SearchResults;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.britinsurance.web.components.SearchBar.SEARCH_BUTTON;
import static com.britinsurance.web.components.SearchBar.SEARCH_INPUT;

public class Search {
  public static Performable byTerm(String keyword) {
    return Task.where("{0} searches for " + keyword + " in the top right search bar",
        Click.on(SEARCH_BUTTON).afterWaitingUntilEnabled(),
        Wait.until(WebElementQuestion.the(SEARCH_INPUT), WebElementStateMatchers.isEnabled())
            .forNoMoreThan(Duration.ofSeconds(70)),
        Click.on(SEARCH_INPUT),
        Enter.theValue(keyword).into(SEARCH_INPUT).thenHit(Keys.ENTER),
        Wait.until(WebElementQuestion.the(SearchResults.RESULTS_HEADER), WebElementStateMatchers.isPresent())
    );
  }
}
