package com.eos.java8;

import java.util.Optional;

public class Domain {

    int id;
    String name;
    Optional<Address> address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }
}

class Address {

    Optional<Country> country;

    public Optional<Country> getCountry() {
        return country;
    }

    public void setCountry(Optional<Country> country) {
        this.country = country;
    }
}

class Country {

    String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
