public class Pet {
    private String nickname;
    private int age;

    public Pet(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{nickname='" + nickname + "', age=" + age + "}";
    }
}
