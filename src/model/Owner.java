package model;

import exception.InvalidInputException;

public class Owner extends Person {

    private long id;
    private String address;

    public Owner(String id, String name, String phoneNumber, String address)
            throws InvalidInputException {
        super(name, phoneNumber);
        this.id = Long.parseLong(id);
        this.address = address;

        try {
            long parsedId = Long.parseLong(id);
            setId(parsedId);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("ID must be a number");
        }

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

    public long getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
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
        return "Owner{id=" + id + ", name='" + name + "', phone='" + phoneNumber + "', address='" + address + "'}";
    }
}
