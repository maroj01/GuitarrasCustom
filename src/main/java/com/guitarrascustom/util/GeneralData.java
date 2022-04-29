package com.guitarrascustom.util;

import com.github.javafaker.Faker;
import com.guitarrascustom.models.RegisterModel;

import static com.guitarrascustom.util.EnumTimeOut.EIGHT;
import static com.guitarrascustom.util.EnumTimeOut.SIXTEEN;

public class GeneralData {

    private GeneralData() {
        throw new AssertionError("Instantiating utility class.");
    }

    public static RegisterModel registerModel() {
        Faker faker = new Faker();


        RegisterModel registerModel = new RegisterModel();

        registerModel.setEmail(faker.internet().emailAddress());
        registerModel.setPassword(faker.internet().password(EIGHT.getValue(), SIXTEEN.getValue(), true));
        registerModel.setUserName(faker.name().username());


        return registerModel;

    }

}
