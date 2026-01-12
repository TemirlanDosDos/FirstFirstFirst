public class Person {
    protected String name;
    protected String phoneNumber;

    public Person(String name, String phoneNumber) {
        setName(name);
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public String getRole() {
        return "Person";
    }

    public String work() {
        return "Person works";
    }

    @Override
    public String toString() {
        return getRole() + "{name='" + name + "', phone='" + phoneNumber + "'}";
    }
}
