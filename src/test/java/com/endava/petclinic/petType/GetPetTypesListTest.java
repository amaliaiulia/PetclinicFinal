package com.endava.petclinic.petType;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetTypes;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.Matchers.is;

public class GetPetTypesListTest extends TestBaseClass {

    @Test
    public void shouldGetPetType() {
        //GIVEN
        PetTypes petTypes = fixture.createPetType()
                .getPetTypes();
        Long petTypeId = petTypes.getId();

        //WHEN
        Response response = petTypesClient.getPetTypesList();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id == %s }.name", withArgs(petTypeId), is(petTypes.getName()));

    }

}
