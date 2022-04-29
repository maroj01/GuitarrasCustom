package com.guitarrascustom.userinterface.logout;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Logout extends PageObject {

    public static final Target LOGOUT_BUTTON = Target
            .the("Logout")
            .located(By.xpath("//button[@class='btn btn-dark mr-2']"));
}
