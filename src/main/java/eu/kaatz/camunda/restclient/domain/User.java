package eu.kaatz.camunda.restclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
        private Integer id;
        private String email;
        private String firstName;
        private String lastName;
}

