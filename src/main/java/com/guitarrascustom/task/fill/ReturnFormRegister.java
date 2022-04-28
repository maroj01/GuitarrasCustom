package com.guitarrascustom.task.fill;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.guitarrascustom.userinterface.logout.Logout.LOGOUT;

public class ReturnFormRegister implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Click.on(LOGOUT)
        );
    }
    public static ReturnFormRegister returnFormRegister() {
        return new ReturnFormRegister();
    }
}
