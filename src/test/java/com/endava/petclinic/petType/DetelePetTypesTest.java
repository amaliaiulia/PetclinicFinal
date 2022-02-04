package com.endava.petclinic.petType;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.fixture.PetClinicFixture;
import com.endava.petclinic.model.PetTypes;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DetelePetTypesTest extends TestBaseClass {

    @Test
    public void shouldDetelePetTypes() {
        //GIVEN
        PetTypes petTypes = fixture.createPetType()
                .getPetTypes();
        Long petTypeId = petTypes.getId();
        //WHEN
        Response response1 = petTypesClient.deletePetTypesById(petTypeId);

        //THEN
        response1.then().statusCode(HttpStatus.SC_NO_CONTENT);


    }

}
