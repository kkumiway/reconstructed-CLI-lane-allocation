// 이용자의 정보
public class Person {
    private String name;
    private int experience;

    public Person(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExp() {
        return experience;
    }
}
