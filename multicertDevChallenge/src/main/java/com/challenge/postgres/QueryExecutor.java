package com.challenge.postgres;

import com.challenge.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.challenge.queries.QueryStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryExecutor {

    Connection c;
    QueryStorage qs = new QueryStorage();

    public QueryExecutor(Connection connection) {
        this.c = connection;
    }

    public ArrayList<Client> ExecuteGetClientsQuery(){
        String query = qs.getAllClients();
        try (PreparedStatement pst = c.prepareStatement(query); ResultSet rs = pst.executeQuery()){
            c.setAutoCommit(false);
            ArrayList<Client> callNumbers = new ArrayList<>();
            while (rs.next()) {
                Client client = new Client(rs.getString("cname"), Integer.parseInt(rs.getString("cnif")), rs.getString("caddress"),Integer.parseInt(rs.getString("pn")));
                callNumbers.add(client);
            }
            rs.close();
            return callNumbers;

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);


        }
    }

    public ArrayList<Client> ExecuteGetClientsByNameQuery(String name){
        String query = qs.getClientsByName(name);
        try (PreparedStatement pst = c.prepareStatement(query); ResultSet rs = pst.executeQuery()){
            c.setAutoCommit(false);
            ArrayList<Client> callNumbers = new ArrayList<>();
            while (rs.next()) {
                Client client = new Client(rs.getString("cname"), Integer.parseInt(rs.getString("cnif")), rs.getString("caddress"),Integer.parseInt(rs.getString("pn")));
                callNumbers.add(client);
            }
            rs.close();
            return callNumbers;

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);


        }
    }

    public ArrayList<Client> ExecuteGetClientByNif(int nif){
        String query = qs.getClientByNif(nif);
        try (PreparedStatement pst = c.prepareStatement(query); ResultSet rs = pst.executeQuery()){
            c.setAutoCommit(false);
            ArrayList<Client> callNumbers = new ArrayList<>();
            while (rs.next()) {
                Client client = new Client(rs.getString("cname"), Integer.parseInt(rs.getString("cnif")), rs.getString("caddress"),Integer.parseInt(rs.getString("pn")));
                callNumbers.add(client);
            }
            rs.close();
            return callNumbers;

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);


        }
    }

    public void ExecuteDeleteQuery(int id){
        try (PreparedStatement pst = c.prepareStatement(qs.deleteClient(id))){
            c.setAutoCommit(true);
            pst.executeUpdate();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);
        }
    }

    public void ExecuteInsertClientQuery(String client_name, int client_nif, String client_address, int phone_number){
        try (PreparedStatement pst = c.prepareStatement(qs.insertClientQuery(client_name, client_nif,client_address, phone_number))){
            c.setAutoCommit(true);
            pst.executeUpdate();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404", e);
        }
    }

}
