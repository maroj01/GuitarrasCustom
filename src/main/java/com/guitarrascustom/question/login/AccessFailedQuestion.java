package com.guitarrascustom.question.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.guitarrascustom.userinterface.register.Registration.ERROR_MESSAGE;

public class AccessFailedQuestion implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {

        return ERROR_MESSAGE.resolveFor(actor).
                isVisible();
    }

    public AccessFailedQuestion is() {
        return this;
    }

    public static AccessFailedQuestion accessFailedQuestion() {
        return new AccessFailedQuestion();

    }
}
