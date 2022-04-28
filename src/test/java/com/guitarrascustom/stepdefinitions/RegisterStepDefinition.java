package com.guitarrascustom.stepdefinitions;

import com.guitarrascustom.models.RegisterModel;
import com.guitarrascustom.question.login.AccessHomeQuestion;
import com.guitarrascustom.stepdefinitions.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.guitarrascustom.question.login.AccessFailedQuestion.accessFailedQuestion;
import static com.guitarrascustom.task.fill.ReturnFormRegister.returnFormRegister;
import static com.guitarrascustom.task.fill.FillRegister.fillRegister;
import static com.guitarrascustom.task.landingpage.OpenLandingPage.openLandingPage;
import static com.guitarrascustom.util.GeneralData.registerModel;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class RegisterStepDefinition extends SetUp {
    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);
    private static final String ACTOR_NAME = "Admin";
    private static RegisterModel registerModel;


    @Given("you entered the Guitar Custom website")
    public void enterWebsite() {
        try {
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage());
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("I register with the requested data")
    public void recordData() {
        try {
            registerModel = registerModel();
            theActorInTheSpotlight().attemptsTo(
                    fillRegister()
                            .withEmail(registerModel.getEmail())
                            .withPassword(registerModel.getPassword())
                            .andUserName(registerModel.getUserName())
            );

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @Then("I can login to the account")
    public void logiAccount() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(AccessHomeQuestion.accessHomeQuestion(), notNullValue()

                    )
            );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    @Given("I already had a record with the mail")
    public void tryRegistration() {

        try {
            registerModel = registerModel();
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage(),
                    fillRegister()
                            .withEmail(registerModel.getEmail())
                            .withPassword(registerModel.getPassword())
                            .andUserName(registerModel.getUserName()),
                    returnFormRegister()
            );

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("I try to register with the same email")
    public void enterSameEmail() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    fillRegister()
                            .withEmail(registerModel.getEmail())
                            .withPassword(registerModel.getPassword())
                            .andUserName(registerModel.getUserName())
            );

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("it will not allow to create the account")
    public void denyRegistration() {
        theActorInTheSpotlight().should(
                seeThat(
                        accessFailedQuestion().is(),
                        equalTo(true)
                )
        );
    }

}
