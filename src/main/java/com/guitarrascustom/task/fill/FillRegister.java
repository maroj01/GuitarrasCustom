package com.guitarrascustom.task.fill;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.guitarrascustom.userinterface.register.Registration.*;
import static com.guitarrascustom.util.EnumTimeOut.TEN;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillRegister implements Task {

    private String username;
    private String password;
    private String email;

    public FillRegister withEmail(String email) {
        this.email = email;
        return this;
    }

    public FillRegister withPassword(String password) {
        this.password = password;
        return this;
    }

    public FillRegister andUserName(String username) {
        this.username = username;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(OPTION_LOGIN, isVisible()).forNoMoreThan(TEN.getValue()).seconds(),

                Click.on(OPTION_LOGIN),
                Enter.theValue(email).into(EMAIL_REGISTER),
                Enter.theValue(password).into(PASS_REGISTER),
                Enter.theValue(password).into(CONFIRM_PASS),
                Enter.theValue(username).into(USERNAME),
                Click.on(REGISTER_BUTTON)
        );
    }

    public static FillRegister fillRegister() {
        return new FillRegister();
    }

}

