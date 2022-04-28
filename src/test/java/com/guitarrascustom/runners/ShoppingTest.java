package com.guitarrascustom.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        strict = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/guitarrascustom/shopping.feature"},
        glue = {"com.guitarrascustom.stepdefinitions"}
)

public class ShoppingTest {
}
