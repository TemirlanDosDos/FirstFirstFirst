public class Pet {
    private String nickname;
    private int age;
    private String type;
    private String sex;
    private String symptom;

    public Pet(String nickname, int age, String type, String sex, String symptom) {
        this.nickname = nickname;
        this.age = age;
        this.type = type;
        this.sex = sex;
        this.symptom = symptom;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public String getSex() {
        return sex;
    }

    public String getSymptom() {
        return symptom;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", symptom='" + symptom + '\'' +
                '}';
    }
}
