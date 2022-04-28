package com.guitarrascustom.userinterface.logout;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Logout extends PageObject {

    public static final Target LOGOUT = Target
            .the("Logout")
            .located(By.xpath("//button[contains(text(),'Cerrar Sesion')]"));
}