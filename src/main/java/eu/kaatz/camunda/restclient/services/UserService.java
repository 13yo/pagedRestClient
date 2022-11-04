package eu.kaatz.camunda.restclient.services;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import eu.kaatz.camunda.restclient.clients.UserClient;
import eu.kaatz.camunda.restclient.domain.CustomReqresUserPageImpl;
import eu.kaatz.camunda.restclient.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserClient client;

    public List<User> getFirstUsersPage(){
        return client.getUsersPage(0).getContent();
    }

    public List<User> getAllUsers(){
        var usersList = new ArrayList<User>();
        var page = client.getUsersPage(0);

        usersList.addAll(page.getContent());
        do {
            page = client.getUsersPage(page.nextPageable().getPageNumber()+1);
            usersList.addAll(page.getContent());
        } while (page.hasNext());

        return usersList;
    }
}
