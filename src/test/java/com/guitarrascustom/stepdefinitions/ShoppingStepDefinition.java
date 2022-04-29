package com.guitarrascustom.stepdefinitions;

import com.guitarrascustom.stepdefinitions.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.guitarrascustom.question.shopping.ConfirmPurchaseQuestion.confirmPurchaseQuestion;
import static com.guitarrascustom.question.shopping.FailedPurchaseQuestion.failedPurchaseQuestion;
import static com.guitarrascustom.task.shopping.ShoppingFileSupport.shoppingFileSupport;
import static com.guitarrascustom.task.shopping.ShoppingNumberSupport.shoppingNumberSupport;
import static com.guitarrascustom.task.fill.FillLogIn.fillLogIn;
import static com.guitarrascustom.task.landingpage.OpenLandingPage.openLandingPage;
import static com.guitarrascustom.util.Dictionary.EMAIL;
import static com.guitarrascustom.util.Dictionary.PASSWORD;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ShoppingStepDefinition extends SetUp {
    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);
    private static final String ACTOR_NAME = "Admin";

    @Given("I am connected to the store's website")
    public void connectStoresWebsite() {
        try {
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage(),
                    fillLogIn()
                            .withEmail(EMAIL)
                            .andPassword(PASSWORD)
            );
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("I make the purchase process without proof of payment")
    public void iMakeThePurchaseProcessWithoutProofOfPayment() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    shoppingFileSupport()
            );

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("an error message will be displayed")
    public void anErrorMessageWillBeDisplayed() {
        theActorInTheSpotlight().should(
                seeThat(
                        failedPurchaseQuestion().is(),
                        equalTo(true)
                )
        );
    }

    @When("I make the purchase process with receipt number")
    public void makePurchaseProcessWithReceiptNumber() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    shoppingNumberSupport()
            );
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @Then("a message with order number will be displayed")
    public void showMessageOrderNumber() {
        theActorInTheSpotlight().should(
                seeThat(
                        confirmPurchaseQuestion().is(),
                        equalTo(true)
                )
        );
    }




}
