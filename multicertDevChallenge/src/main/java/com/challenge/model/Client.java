package com.challenge.model;

import java.math.BigInteger;

public class Client {


    BigInteger id;
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

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getClient_nif() {
        return client_nif;
    }

    public void setClient_nif(int client_nif) {
        this.client_nif = client_nif;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}
