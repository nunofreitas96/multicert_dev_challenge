package com.challenge.rest;

import com.challenge.model.Client;
import com.challenge.postgres.PostgresConnection;
import com.challenge.postgres.QueryExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
public class WebServiceController {

    PostgresConnection dbconnection = new PostgresConnection("localhost:5432/postgres","postgres","password");
    QueryExecutor querier = new QueryExecutor(dbconnection.getConnection());


    @CrossOrigin
    @PostMapping("/addclient")
    public ResponseEntity<?> newNumber(@RequestBody HashMap<String,String> newClient) {
        try {

            Client nC = new Client(newClient.get("clientName"), Integer.parseInt(newClient.get("clientNif")), newClient.get("clientAddress"), Integer.parseInt(newClient.get("phoneNumber")));
            querier.ExecuteInsertClientQuery(nC.getClient_name(), nC.getClient_nif(), nC.getClient_address(), nC.getPhone_number());
            return ResponseEntity.ok(HttpStatus.OK);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);

        }
    }

    @CrossOrigin
    @DeleteMapping("/deleteclient/{id}")
    public ResponseEntity<?> deleteCall(@PathVariable Integer id) {
        try {
            querier.ExecuteDeleteQuery(id);

            return ResponseEntity.ok(HttpStatus.OK);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);

        }
    }

    @CrossOrigin
    @GetMapping("/clients")
    public ArrayList<Client> allClients() {
        try {
            return querier.ExecuteGetClientsQuery();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);

        }
    }
    @CrossOrigin
    @GetMapping("/clients/{name}")
    public ArrayList<Client> allClientsByName(@PathVariable String name) {
        try {

            return querier.ExecuteGetClientsByNameQuery(name);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);

        }
    }

    @CrossOrigin
    @GetMapping("/client/{nif}")
    public ArrayList<Client> allClientsByNif(@PathVariable int nif) {
        try {


            return querier.ExecuteGetClientByNif(nif);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);

        }
    }





}
