// 자유 수영 레인
public class FreeLane extends Lane {
    private int minExp; // 이 레인에 입장하기 위해 필요한 최소 수영 경력(1개월, 3개월, 6개월, 12개월)
    private boolean useFin; // 핀 사용 레인인지 여부

    public FreeLane(int openingTime, int closingTime, int laneNum, int length, double depth, int minExp, boolean useFin) {
        super(openingTime, closingTime, laneNum, length, depth);
        this.minExp = minExp;
        this.useFin = useFin;
    }

    public int getMinExp(){
        return minExp;
    }

    public boolean getUseFin(){
        return useFin;
    }

    public void assignLane(Person person) {
        System.out.println(person.getName() + "님은 " + laneNum + "번 레인(자유수영, 핀 사용)에 배정되었습니다.");
    }

    public boolean assignFinLane(Person person) {
        if (useFin) {
            System.out.println(person.getName() + "님은 " + laneNum + "번 레인(자유수영, 핀 사용)에 배정되었습니다.");
            return true;
        }
        return false;
    }

    @Override
    public void printStatus() {
        if (useFin){
            System.out.println(laneNum + "번 레인 - 자유수영(핀 사용), 레인 길이: " + length + "m, 레인 수심: " + depth + "m");
        }
        else{
            System.out.println(laneNum + "번 레인 - 자유수영(최소 경력: " + minExp + "), 레인 길이: " + length + "m, 레인 수심: " + depth + "m");
        }
    }
}
