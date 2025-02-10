package model;

// 이용자의 정보
public class Person {
    private final String name;
    private final int experience;

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
