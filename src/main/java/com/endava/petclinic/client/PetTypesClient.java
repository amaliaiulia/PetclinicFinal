package com.endava.petclinic.client;

import com.endava.petclinic.model.PetTypes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetTypesClient extends BaseClient {

    public Response createPetType(PetTypes petTypes) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(petTypes)
                .post("api/pettypes");
    }

    public Response getPetTypeByID(Long petTypeId) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(petTypeId)
                .pathParam("petTypeId", petTypeId)
                .get("api/pettypes/{petTypeId}");
    }

    public Response getPetTypesList() {
        return getBasicRestConfig()
                .get("api/pettypes");
    }

    public Response deletePetTypesById(Long petTypeId) {
        return getBasicRestConfig()
                .pathParam("petTypeId", petTypeId)
                .delete("api/pettypes/{petTypeId}");
    }

    public Response updatePetTypeById(Long petTypeId, PetTypes petTypes) {
        return getBasicRestConfig()
                .pathParam("petTypeId", petTypeId)
                .put("api/pettypes/{petTypeId}");
    }


}
