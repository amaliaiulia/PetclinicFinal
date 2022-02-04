package com.endava.petclinic.petType;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetTypes;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreatePetTypesTest extends TestBaseClass {

    @Test
    public void shouldCreatePetTypes() {
        //GIVEN
        PetTypes petTypes = testDataProvider.getPetTypes();

        //WHEN
        Response response = petTypesClient.createPetType(petTypes);

        //THEN

        response.then().statusCode(HttpStatus.SC_CREATED);

    }


}
