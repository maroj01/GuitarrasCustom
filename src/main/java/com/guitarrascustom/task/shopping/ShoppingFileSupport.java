package com.guitarrascustom.task.shopping;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.guitarrascustom.userinterface.shopping.Shopping.*;
import static com.guitarrascustom.util.Dictionary.CHOOSE_FILE;
import static com.guitarrascustom.util.EnumTimeOut.TEN;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ShoppingFileSupport implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                SelectFromOptions.byVisibleText("Acústica").from(GUITAR_TYPE),
                SelectFromOptions.byVisibleText("Grand Concert").from(GUITAR_MODEL_MENU),
                SelectFromOptions.byVisibleText("Gibson").from(GUITAR_BRAND_MENU),
                SelectFromOptions.byVisibleText("6").from(GUITAR_NUMBER_ROPE_MENU),
                SelectFromOptions.byVisibleText("Nylon").from(GUITAR_TYPE_ROPE_MENU),
                SelectFromOptions.byVisibleText("D").from(GUITAR_TUNING_MENU),

                WaitUntil.the(SEARCH_PRODUCTS, isVisible()).forNoMoreThan(TEN.getValue()).seconds(),
                Click.on(SEARCH_PRODUCTS),
                Scroll.to(BUY_PRODUCT),
                Click.on(CHECK_LUTTIER),
                Click.on(BUY_PRODUCT),

                Scroll.to(FIND_SUPPORT),
                Click.on(CUSTOM_SWITCH),
                Click.on(FIND_SUPPORT),
                SendKeys.of(CHOOSE_FILE).into(CARGE_BUTTON)

                //Enter.keyValues(CHOOSE_FILE).into(CARGE_BUTTON)


        );
    }

    public static ShoppingFileSupport shoppingFileSupport() {

        return new ShoppingFileSupport();
    }

}
