package eu.kaatz.camunda.restclient;

import eu.kaatz.camunda.restclient.clients.UserClient;
import eu.kaatz.camunda.restclient.domain.CustomReqresUserPageImpl;
import eu.kaatz.camunda.restclient.domain.User;
import eu.kaatz.camunda.restclient.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CommandLine implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        log.info("EXECUTING : command line runner");

        Options options = new Options();
        Option full = new Option("f", "full", false, "Get all users");
        full.setRequired(false);
        options.addOption(full);

        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        org.apache.commons.cli.CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("User Data retriever", options);
            System.exit(1);
            return;
        }

        List<User> users;
        if (cmd.hasOption("f")) {
            System.out.println("Getting the full list of users ... ");
            users = userService.getAllUsers();
        } else {
            System.out.print("Retrieving the first users page ... ");
            users = userService.getFirstUsersPage();
        }

        System.out.println("DONE");
        System.out.println("These are the names of the user (<last name>, <first name>):");
        users.stream().forEach(data -> System.out.println(data.getLastName() + ", " + data.getFirstName() ));
    }

}
