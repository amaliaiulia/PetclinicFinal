package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetTypes;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeletePetTest extends TestBaseClass {

    @Test
    public void shouldDeletePet() {
        //GIVEN
        Owner owner = fixture.createOwner()
                .getOwner();

        PetTypes petType = new PetTypes();
        petType.setId(1L);

        Pet pet = testDataProvider.getPet(owner,petType);
        Response createPetResponse = petClient.createPet(pet);
        createPetResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long petId = createPetResponse.body().jsonPath().getLong("id");

        //WHEN
        Response response1 = petClient.deletePetById(petId);

        //THEN
        response1.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }


}
