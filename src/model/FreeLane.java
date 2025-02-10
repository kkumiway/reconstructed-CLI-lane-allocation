package model;

// 자유 수영 레인
public class FreeLane extends Lane {
    private final int minExp; // 이 레인에 입장하기 위해 필요한 최소 수영 경력(1개월, 3개월, 6개월, 12개월)
    private final boolean useFin; // 핀 사용 레인인지 여부

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

    public boolean checkIfUseFin(){
        if (useFin){
            return true;
        }else {
            return false;
        }
    }

    public boolean checkIfSuitableLane(Person person){
        // 핀 레인이 아닌 레인에서만 실행
        // 지금 레인의 요구 경력 <= 이용자의 경력 < 다음 레인의 요구 경력일 때만 배정
        return !useFin && (person.getExp() >= minExp);
    }

    public void printResult(Person person){
        if (useFin){
            System.out.println("\n" + person.getName() + "님은 " + laneNum + "번 레인(자유수영, 핀 사용)에 배정되었습니다.");
        }
        else{
            System.out.println("\n" + person.getName() + "님은 " + laneNum + "번 자유 레인에 배정되었습니다.");
        }
    }

    @Override
    public void printStatus() {
        if (useFin){
            System.out.println(laneNum + "번 레인 - 자유수영(핀 사용), 레인 길이: " + length + "m, 레인 수심: " + depth + "m");
        }
        else{
            System.out.println(laneNum + "번 레인 - 자유수영(최소 경력: " + minExp + "개월), 레인 길이: " + length + "m, 레인 수심: " + depth + "m");
        }
    }
}
