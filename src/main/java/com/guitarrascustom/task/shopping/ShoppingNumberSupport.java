package com.guitarrascustom.task.shopping;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.guitarrascustom.userinterface.shopping.Shopping.*;
import static com.guitarrascustom.util.Dictionary.NUMERO_COMPROBANTE;
import static com.guitarrascustom.util.EnumTimeOut.TEN;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ShoppingNumberSupport implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                SelectFromOptions.byVisibleText("Electroacústica").from(GUITAR_TYPE),
                SelectFromOptions.byVisibleText("Jumbo").from(GUITAR_MODEL_MENU),
                SelectFromOptions.byVisibleText("Yamaha").from(GUITAR_BRAND_MENU),
                SelectFromOptions.byVisibleText("6").from(GUITAR_NUMBER_ROPE_MENU),
                SelectFromOptions.byVisibleText("Acero").from(GUITAR_TYPE_ROPE_MENU),
                SelectFromOptions.byVisibleText("E").from(GUITAR_TUNING_MENU),

                WaitUntil.the(SEARCH_PRODUCTS, isVisible()).forNoMoreThan(TEN.getValue()).seconds(),
                Click.on(SEARCH_PRODUCTS),
                Scroll.to(BUY_PRODUCT),
                Click.on(CHECK_LUTTIER),
                Click.on(BUY_PRODUCT),
                Enter.theValue(NUMERO_COMPROBANTE).into(INPUT_RECEIPT),
                Click.on(SEND_RECEIPT)
        );
    }

    public static ShoppingNumberSupport shoppingNumberSupport() {

        return new ShoppingNumberSupport();
    }
}
