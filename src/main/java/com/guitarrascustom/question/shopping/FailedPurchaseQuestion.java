package com.guitarrascustom.question.shopping;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.guitarrascustom.userinterface.shopping.Shopping.ERROR_VOUCHER;

public class FailedPurchaseQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return ERROR_VOUCHER.resolveFor(actor).isVisible();
    }


    public FailedPurchaseQuestion is() {
        return this;
    }


    public static FailedPurchaseQuestion failedPurchaseQuestion() {
        return new FailedPurchaseQuestion();

    }
}
