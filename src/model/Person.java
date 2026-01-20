package model;

public abstract class Person implements Workable {

    protected String name;
    protected String phoneNumber;

    public Person(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phoneNumber = phoneNumber;
    }

    public abstract String getRole();

    @Override
    public abstract String work();

    @Override
    public String toString() {
        return getRole() + "{name='" + name + "', phone='" + phoneNumber + "'}";
    }
}
