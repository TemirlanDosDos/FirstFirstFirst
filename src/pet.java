public class pet {
    private String nickname;
    private int age;
    private String type;
    private String sex;
    private String symptom;

    public pet(String nickname, int age, String type, String sex, String symptom) {
        this.nickname = nickname;
        this.age = age;
        this.type = type;
        this.sex = sex;
        this.symptom = symptom;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Override
    public String toString() {
        return "pet{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", symptom='" + symptom + '\'' +
                '}';
    }
}