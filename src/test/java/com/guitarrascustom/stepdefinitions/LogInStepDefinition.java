package com.guitarrascustom.stepdefinitions;

import com.guitarrascustom.question.login.AccessHomeQuestion;
import com.guitarrascustom.stepdefinitions.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.guitarrascustom.question.login.AccessFailedQuestion.accessFailedQuestion;
import static com.guitarrascustom.task.fill.FillLogIn.fillLogIn;
import static com.guitarrascustom.task.landingpage.OpenLandingPage.openLandingPage;
import static com.guitarrascustom.util.Dictionary.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LogInStepDefinition extends SetUp {

    private static final Logger LOGGER = Logger.getLogger(LogInStepDefinition.class);
    private static final String ACTOR_NAME = "Admin";


    @Given("I enter the login page of the Guitar Custom page")
    public void enterWebsite() {
        try {
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage());
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("I authenticate with the email and password")
    public void authenticateEmailPassword() {

        try {
            theActorInTheSpotlight().attemptsTo(
                    fillLogIn()
                            .withEmail(EMAIL)
                            .andPassword(PASSWORD)
            );

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("the main page will be displayed")
    public void SeeHomePage() {

        try {
            theActorInTheSpotlight().should(
                    seeThat(AccessHomeQuestion.accessHomeQuestion(), notNullValue())

            );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


    @When("I authenticate with wrong email and password")
    public void authenticateErrorData() {

        try {
            theActorInTheSpotlight().attemptsTo(
                    fillLogIn()
                            .withEmail(EMAIL_ADRESS)
                            .andPassword(PASSWORD)
            );

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @Then("the error message will be displayed")
    public void seeErrorMessage() {

        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            accessFailedQuestion().is(),
                            equalTo(true)
                    )
            );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
