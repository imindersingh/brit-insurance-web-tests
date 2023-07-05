package com.britinsurance.web.features;

import com.britinsurance.web.actions.NavigateTo;
import com.britinsurance.web.actions.Search;
import com.britinsurance.web.components.SearchResults;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
class TestSearchingForTerms {

  @CastMember(name = "Iminder")
  Actor iminder;

  @ParameterizedTest
  @CsvFileSource(resources = "/data/search_results.csv", numLinesToSkip = 1)
  @DisplayName("Test - Can search for terms")
  void testSearchingForTerms_ReturnsCorrectResults(final String searchTerm, final String expectedResultsString, final int expectedResultCount) {
    iminder.attemptsTo(
        NavigateTo.theHomePage(),
        Search.byTerm(searchTerm)
    );
    final List<String> actualResults = SearchResults.linkTexts().answeredBy(iminder);
    final List<String> expectedResults = List.of(expectedResultsString.split(",\\s*"));
    iminder.attemptsTo(
        Ensure.that(actualResults.size()).isEqualTo(expectedResultCount),
        Ensure.that(actualResults).containsExactlyElementsFrom(expectedResults)
    );
  }
}
