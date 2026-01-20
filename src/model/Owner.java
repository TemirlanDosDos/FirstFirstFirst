package model;

import exception.InvalidInputException;

public class Owner extends Person {

    private long id;
    private String address;

    public Owner(long id, String name, String phoneNumber, String address)
            throws InvalidInputException {
        super(name, phoneNumber);
        setId(id);
        setAddress(address);
    }

    public void setId(long id) throws InvalidInputException {
        if (id <= 0) {
            throw new InvalidInputException("ID must be positive");
        }
        this.id = id;
    }

    public void setAddress(String address) throws InvalidInputException {
        if (address == null || address.isBlank()) {
            throw new InvalidInputException("Address cannot be empty");
        }
        this.address = address;
    }

    @Override
    public String getRole() {
        return "Owner";
    }

    @Override
    public String work() {
        return "Owner takes care of pets";
    }

    @Override
    public String toString() {
        return "Owner{id=" + id + ", name='" + name + "'}";
    }
}
