package com.guitarrascustom.task.fill;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.guitarrascustom.userinterface.login.Login.*;
import static com.guitarrascustom.util.EnumTimeOut.TEN;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillLogIn implements Task {

    private String email;
    private String password;

    public FillLogIn withEmail(String email) {
        this.email = email;
        return this;
    }

    public FillLogIn andPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(EMAIL_LOGIN, isVisible()).forNoMoreThan(TEN.getValue()).seconds(),
                Enter.theValue(email).into(EMAIL_LOGIN),
                Enter.theValue(password).into(PASSWORD),
                Click.on(LOGIN_BTN)
        );
    }

    public static FillLogIn fillLogIn() {
        return new FillLogIn();
    }
}
