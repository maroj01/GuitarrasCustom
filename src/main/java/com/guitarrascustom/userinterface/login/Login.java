package com.guitarrascustom.userinterface.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login extends PageObject {

    public static final Target EMAIL_LOGIN = Target
            .the("Email")
            .located(By.id("email"));

    public static final Target PASSWORD = Target
            .the("Pass")
            .located(By.id("pass"));

    public static final Target LOGIN_BTN = Target
            .the("Login")
            .located(By.id("buttonLoginRegister"));





}
