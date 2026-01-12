public class Owner extends Person {
    private long id;
    private String address;

    public Owner(long id, String name, String phoneNumber, String address) {
        super(name, phoneNumber);
        setId(id);
        this.address = address;
    }

    public void setId(long id) {
        this.id = id > 0 ? id : 0;
    }

    @Override
    public String getRole() {
        return "Owner";
    }

    @Override
    public String toString() {
        return "Owner{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public String work() {
        return "Owner takes care of pets";
    }

}

