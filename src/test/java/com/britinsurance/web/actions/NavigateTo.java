package com.britinsurance.web.actions;

import com.britinsurance.web.components.HomePage;
import com.britinsurance.web.components.Menu;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class NavigateTo {
  public static Performable theHomePage() {
    return Task.where("{0} navigates to the Brit Insurance home page",
        Open.browserOn()
            .the(HomePage.class));
  }

  public static Performable contactPageFromTheMenu() {
    return Task.where("{0} navigates to the Contact page from the menu",
        Wait.until(WebElementQuestion.the(Menu.MENU_BUTTON), WebElementStateMatchers.isClickable()),
        MoveMouse.to(Menu.MENU_BUTTON),
        Click.on(Menu.MENU_BUTTON),
        Scroll.to(Menu.CONTACT_LINK)
              .then(Click.on(Menu.CONTACT_LINK))
    );
  }
}
