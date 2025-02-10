package model;

public class Lane extends Pool {
    protected int laneNum; // 레인 번호
    protected int length;  // 25m or 50m
    protected double depth; // 수심

    public Lane(int openingTime, int closingTime, int laneNum, int length, double depth) {
        super(openingTime, closingTime);
        this.laneNum = laneNum;
        this.length = length;
        this.depth = depth;
    }

    public void printStatus() {
        System.out.println(laneNum + "번 레인 - 레인 길이: " + length + "m, 레인 수심: " + depth + "m");
    }
}
