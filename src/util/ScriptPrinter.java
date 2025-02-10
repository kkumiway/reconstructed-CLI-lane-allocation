package util;

import model.ClassLane;
import model.FreeLane;

import java.util.List;

public class ScriptPrinter {
    public ScriptPrinter(){
    }

    public void printStartScript(){
        System.out.println("************************************************");
        System.out.println("    🌊🌊🌊 카테부 수영장에 오신 것을 환영합니다! 🌊🌊🌊");
        System.out.println("************************************************");
    }

    public void printLaneList(List<ClassLane> classLanes, List<FreeLane> freeLanes){
        System.out.println("현재 이용할 수 있는 레인 목록:");
        System.out.println("-------------------------------------------------");

        for(ClassLane lane : classLanes) {
            lane.printStatus();
        }
        for(FreeLane lane : freeLanes) {
            lane.printStatus();
        }

        System.out.println("-------------------------------------------------");
    }
}
