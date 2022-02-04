package com.endava.petclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor  //constr fara niciun param
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    @EqualsAndHashCode.Exclude
    private Long id;
    @NonNull //se adauga la constr
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NonNull
    private String city;
    @NonNull
    private String telephone;


    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }


}
