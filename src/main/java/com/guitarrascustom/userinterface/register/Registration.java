package com.guitarrascustom.userinterface.register;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Registration extends PageObject {

    public static final Target OPTION_LOGIN = Target
            .the("Option Login")
            .located(By.id("optionRegisterLogin"));

    public static final Target EMAIL_REGISTER = Target
            .the("Email Register")
            .located(By.id("email"));

    public static final Target PASS_REGISTER = Target
            .the("Pass Register")
            .located(By.id("pass"));

    public static final Target CONFIRM_PASS = Target
            .the("Confirm Pass")
            .located(By.id("confirm"));

    public static final Target USERNAME = Target
            .the("Username")
            .located(By.id("username"));

    public static final Target REGISTER_BUTTON = Target
            .the("Register Button")
            .located(By.id("buttonLoginRegister"));

    public static final Target ERROR_MESSAGE = Target
            .the("error Form")
            .located(By.id("errorForm"));

    public static final Target TITLE_HOME= Target
            .the("Title")
            .located(By.xpath("/html/body/div/div/div[2]/div[1]"));

}
