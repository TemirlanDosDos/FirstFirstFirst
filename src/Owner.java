public class Owner {
    private long id;
    private String name;
    private String phoneNumber;
    private String address;

    public Owner(long id, String name, String phoneNumber, String address) {
        setId(id);
        setName(name);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void setId(long id) {
        this.id = id > 0 ? id : 0;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    @Override
    public String toString() {
        return "Owner{id=" + id + ", name='" + name + "'}";
    }
}
