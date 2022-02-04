package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetTypes;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.Matchers.is;


public class GetPetListTest extends TestBaseClass {

    @Test
    public void shouldGetPetList() {

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
        Response response = petClient.getPetList();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id == %s }.name", withArgs(petId), is(pet.getName()));

    }

}
