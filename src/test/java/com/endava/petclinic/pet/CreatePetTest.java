package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetTypes;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class CreatePetTest extends TestBaseClass {

    @Test
    public void shouldCreatePet() {
        //GIVEN

        Owner owner = fixture.createOwner()
                .getOwner();


        PetTypes petType = new PetTypes();
        petType.setId(1L);
        Pet pet = testDataProvider.getPet(owner,petType);

        //WHEN
        Response response = petClient.createPet(pet);

        //THEN
        response.then().statusCode(HttpStatus.SC_CREATED);
    }
}
