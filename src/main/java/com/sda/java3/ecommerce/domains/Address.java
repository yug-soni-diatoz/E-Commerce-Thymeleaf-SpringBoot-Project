package com.sda.java3.ecommerce.domains;

import java.util.Objects;

public class Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{street='" + street + "', city='" + city + "', postalCode='" + postalCode + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
               city.equals(address.city) &&
               postalCode.equals(address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, postalCode);
    }
}
