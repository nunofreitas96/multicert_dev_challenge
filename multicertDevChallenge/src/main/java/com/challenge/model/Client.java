package com.challenge.model;

import java.math.BigInteger;

public class Client {


    int id;
    String client_name;
    int client_nif;
    String client_address;
    int phone_number;

    public Client(String client_name, int client_nif, String client_address, int phone_number) {
        this.client_name = client_name;
        this.client_nif = client_nif;
        this.client_address = client_address;
        this.phone_number = phone_number;
    }


    public Client(String client_name, int client_nif, String client_address, int phone_number, int id) {
        this.id = id;
        this.client_name = client_name;
        this.client_nif = client_nif;
        this.client_address = client_address;
        this.phone_number = phone_number;
    }

    public String getClient_name() {
        return client_name;
    }



    public int getClient_nif() {
        return client_nif;
    }



    public String getClient_address() {
        return client_address;
    }


    public int getPhone_number() {
        return phone_number;
    }



    public int getId() {
        return id;
    }
}
