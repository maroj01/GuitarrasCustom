package com.guitarrascustom.question.login;

import com.guitarrascustom.userinterface.register.Registration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class AccessHomeQuestion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(Registration.TITLE_HOME).viewedBy(actor).asString();
    }

    public static AccessHomeQuestion accessHomeQuestion() {
        return new AccessHomeQuestion();
    }

}
