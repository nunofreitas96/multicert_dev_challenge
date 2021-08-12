package com.challenge.queries;

public class QueryStorage {

    public QueryStorage() {
    }

    public String insertClientQuery(String client_name, int client_nif, String client_address, int phone_number){
        return "INSERT INTO client (" +
                " client_name, client_nif, client_address, phone_number) " +
                "VALUES ( "+ client_name +", "+ client_nif +", "+ client_address +", "+ phone_number +");";
    }

    public String getAllClients(){
        return "SELECT client_name as cname, client_nif as cnif, client_address as caddress, phone_number as pn , id FROM client;";
    }

    public String getClientByNif(int client_nif){
        return "SELECT client_name as cname, client_nif as cnif, client_address as caddress, phone_number as pn, id FROM client" +
                " WHERE client.client_nif = '"+ client_nif +"' ;";
    }

    public String getClientsByName(String getClientByName){
        return "SELECT client_name as cname, client_nif as cnif, client_address as caddress, phone_number as pn, id FROM client" +
                " WHERE client.client_name = '"+ getClientByName +"';";
    }

    public String deleteClient(int id){
        return "DELETE FROM client" +
                " WHERE client.id = "+ id +";";
    }



}
