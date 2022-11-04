package eu.kaatz.camunda.restclient.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import eu.kaatz.camunda.restclient.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomReqresUserPageImpl extends PageImpl<User> {
    public CustomReqresUserPageImpl(@JsonProperty("data")  List<User> data,
                                    @JsonProperty("page") int page_num, @JsonProperty("per_page") int size,
                                    @JsonProperty("total") Long totalElements) {
        //Reqres starts counting with 1 but Paging in Spring starts with 0
        super(data, PageRequest.of(page_num-1, size), totalElements);
    }
}
