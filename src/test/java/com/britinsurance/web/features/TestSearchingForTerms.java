package com.britinsurance.web.features;

import com.britinsurance.web.actions.NavigateTo;
import com.britinsurance.web.actions.Search;
import com.britinsurance.web.components.ResultsPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
class TestSearchingForTerms {

    @CastMember(name = "Iminder")
    Actor iminder;

    @Test
    //@CsvSource("{IFRS 17,Interim results for the six months ended 30 June 2022-Gavin Wilkinson-John King}")
    //@CsvFileSource(resources = "/data/data.csv")
    @DisplayName("Test - Can search for terms")
    void testSearchForTerms_ReturnsCorrectResults() {
        iminder.attemptsTo(
                NavigateTo.theHomePage(),
                Search.byTerm("IFRS 17")
        );
        final List<String> actualResults = ResultsPage.returnedResultsLinkTexts().answeredBy(iminder);
        System.out.println("actual results" + actualResults);
        final List<String> expectedResults = List.of("Interim results for the six months ended 30 June 2022", "Gavin Wilkinson", "John King");
        //final List<String> expectedResults = List.of(expectedResultsString.split(",\\s*"));
        iminder.attemptsTo(
                Ensure.that(actualResults.size()).isEqualTo(3),
                Ensure.that(expectedResults).containsExactlyElementsFrom(actualResults)
        );
    }
}
