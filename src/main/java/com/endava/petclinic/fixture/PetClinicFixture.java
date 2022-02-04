package com.endava.petclinic.fixture;

import com.endava.petclinic.client.OwnerClient;
import com.endava.petclinic.client.PetClient;
import com.endava.petclinic.client.PetTypesClient;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.PetTypes;
import com.endava.petclinic.testData.TestDataProvider;
import io.restassured.response.Response;
import lombok.Getter;
import org.apache.http.HttpStatus;


public class PetClinicFixture {

    private OwnerClient ownerClient = new OwnerClient();
    private PetClient petClient = new PetClient();
    private PetTypesClient petTypesClient = new PetTypesClient();

    private TestDataProvider dataProvider = new TestDataProvider();

    @Getter
    private Owner owner;
    @Getter
    private PetTypes petTypes;

    public PetClinicFixture createOwner() {
        owner = dataProvider.getOwner();
        Response response = ownerClient.createOwner(owner);
        response.then().statusCode(HttpStatus.SC_CREATED);

        long id = response.body().jsonPath().getLong("id");
        owner.setId(id);

        return this;
    }

    public PetClinicFixture createPetType() {
        petTypes = dataProvider.getPetTypes();
        Response response = petTypesClient.createPetType(petTypes);
        response.then().statusCode(HttpStatus.SC_CREATED);
        long id = response.body().jsonPath().getLong("id");
        petTypes.setId(id);

        return this;
    }



}
