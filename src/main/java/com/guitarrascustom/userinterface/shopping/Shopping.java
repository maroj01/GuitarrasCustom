package com.guitarrascustom.userinterface.shopping;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Shopping extends PageObject {


    public static final Target GUITAR_TYPE = Target
            .the("Guitar Type")
            .located(By.id("selectOptions"));

    public static final Target GUITAR_MODEL_MENU = Target
            .the("Guitar Model Menu")
            .located(By.xpath("//div[@class='rowFilters row row-cols-lg-4 row-cols-md-3 row-cols-sm-2 row-cols-1']//select[@aria-label='modelo']"));

    public static final Target GUITAR_BRAND_MENU = Target
            .the("Guitar Brand Menu")
            .located(By.xpath("//div[@class='rowFilters row row-cols-lg-4 row-cols-md-3 row-cols-sm-2 row-cols-1']//select[@aria-label='marca']"));

    public static final Target GUITAR_NUMBER_ROPE_MENU = Target
            .the("Guitar Number Rope Menu")
            .located(By.xpath("//div[@class='rowFilters row row-cols-lg-4 row-cols-md-3 row-cols-sm-2 row-cols-1']//select[@aria-label='numero-de-cuerdas']"));

    public static final Target GUITAR_TYPE_ROPE_MENU = Target
            .the("Guitar Type Rope Menu")
            .located(By.xpath("//div[@class='rowFilters row row-cols-lg-4 row-cols-md-3 row-cols-sm-2 row-cols-1']//select[@aria-label='tipo-de-cuerdas']"));

    public static final Target GUITAR_TUNING_MENU = Target
            .the("Guitar Tuning Menu")
            .located(By.xpath("//div[@class='rowFilters row row-cols-lg-4 row-cols-md-3 row-cols-sm-2 row-cols-1']//select[@aria-label='afinacion']"));

    public static final Target SEARCH_PRODUCTS = Target
            .the("Search Products")
            .located(By.id("searchProducts"));

    public static final Target CHECK_LUTTIER = Target
            .the("Check Luttier")
            .located(By.id("checkbox"));

    public static final Target BUY_PRODUCT = Target
            .the("Buy Product")
            .located(By.id("buyProduct"));

    public static final Target CUSTOM_SWITCH = Target
            .the("Custom Switch")
            .located(By.id("custom-switch"));

    public static final Target FIND_SUPPORT = Target
            .the("Find Support")
            .located(By.xpath("/html/body/div/div/div[1]/div/div/div[2]/div[2]/form[2]/div[1]/div/div/button"));

    public static final Target CARGE_BUTTON = Target
            .the("Carge Button")
            .located(By.id("fsp-fileUpload"));

    public static final Target INPUT_RECEIPT = Target
            .the("Input Receipt")
            .located(By.id("inputReceipt"));

    public static final Target SEND_RECEIPT = Target
            .the("Send Receipt")
            .located(By.id("sendReceipt"));


    public static final Target VOUCHER = Target
            .the("Voucher Ok")
            .located(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]"));


}
