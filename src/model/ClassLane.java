package model;

// 강습 수영 레인
public class ClassLane extends Lane {
    private String course; // 강좌명(초급, 중급, 상급, 마스터)
    private int minExp; // 이 레인에 입장하기 위해 필요한 최소 수영 경력(1개월, 3개월, 6개월, 12개월)
    private boolean isChildLane; // 어린이 레인인지 여부

    public ClassLane(int openingTime, int closingTime, int laneNum, int length, double depth, String course, int minExp, boolean isChildLane) {
        super(openingTime, closingTime, laneNum, length, depth);
        this.course = course;
        this.minExp = minExp;
        this.isChildLane = isChildLane;
    }

    public int getMinExp(){
        return minExp;
    }

    public boolean getIsChildLane(){
        return isChildLane;
    }

    public void assignLane(Person person) {
        System.out.println("\n" + person.getName() + "님은 " + laneNum + "번 레인(" + course + ")에 배정되었습니다.");
    }

    public boolean assignChildLane(Person person) {
        if (isChildLane) {
            System.out.println("\n" + person.getName() + "님은 " + laneNum + "번 레인(" + course + ")에 배정되었습니다.");
            return true;
        }
        return false;
    }

    @Override
    public void printStatus() {
        if (isChildLane){
            System.out.println(laneNum + "번 레인 - 강좌명: 어린이 레인, 레인 길이: " + length + "m, 레인 수심: " + depth + "m");
        }
        else{
            System.out.println(laneNum + "번 레인 - 강좌명: " + course + "(최소 경력: " + minExp + "개월), 레인 길이: " + length + "m, 레인 수심: " + depth + "m");
        }
    }
}
