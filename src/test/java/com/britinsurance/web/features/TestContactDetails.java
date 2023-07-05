package com.britinsurance.web.features;

import com.britinsurance.web.actions.NavigateTo;
import com.britinsurance.web.components.ContactPage;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
class TestContactDetails {

  @CastMember(name = "Iminder")
  Actor iminder;

  @Test
  @DisplayName("Test - Bermuda office address is correct")
  void testBermudaContactDetails_AddressIsCorrect() {
    iminder.attemptsTo(
        NavigateTo.theHomePage(),
        NavigateTo.contactPageFromTheMenu()
    );
    final String actualAddress = ContactPage.officeAddress(ContactPage.BERMUDA_ADDRESS).answeredBy(iminder);
    final String expectedAddress =
        "Ground Floor, Chesney House\n"
            + "The Waterfront, 96 Pitts Bay Road,\n"
            + "Pembroke, Hamilton HM 08, Bermuda";
    iminder.attemptsTo(
        Ensure.that(actualAddress).isEqualTo(expectedAddress)
    );
  }
}
