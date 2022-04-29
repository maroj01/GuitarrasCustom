package com.guitarrascustom.question.shopping;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.guitarrascustom.userinterface.shopping.Shopping.VOUCHER;

public class ConfirmPurchaseQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return VOUCHER.resolveFor(actor).
                isVisible();
    }

    public ConfirmPurchaseQuestion is() {
        return this;
    }

    public static ConfirmPurchaseQuestion confirmPurchaseQuestion() {
        return new ConfirmPurchaseQuestion();

    }
}
