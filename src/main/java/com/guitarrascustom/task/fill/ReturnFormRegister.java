package com.guitarrascustom.task.fill;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.guitarrascustom.userinterface.logout.Logout.LOGOUT_BUTTON;

public class ReturnFormRegister implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Click.on(LOGOUT_BUTTON)
        );
    }
    public static ReturnFormRegister returnFormRegister() {
        return new ReturnFormRegister();
    }
}
