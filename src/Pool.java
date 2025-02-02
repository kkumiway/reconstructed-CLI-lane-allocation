public class Pool {
    protected int openingTime; // 개장 시간(24시)
    protected int closingTime; // 폐장 시간(24시)

    public Pool(int openingTime, int closingTime){
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    // 해당 시간에 수영장이 열려 있는지 확인
    public boolean isOpen(int time) {
        return time >= openingTime && time <= closingTime;
    }
}
