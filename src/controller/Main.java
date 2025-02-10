package controller;

import model.*;
import service.PoolService;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pool pool = new Pool(6, 22);  // 개장 시간: 6시, 폐장 시간: 22시
        PoolService poolService = new PoolService(pool);
        List<ClassLane> classLanes = poolService.getClassLanes();
        List<FreeLane> freeLanes = poolService.getFreeLanes();

        // 안내 문구 출력
        Guide guide = new Guide();
        guide.printStartGuide();
        guide.printLaneList(classLanes, freeLanes);

        // 1. 이용 시간 입력
        InputValidator.getValidTimeInput(scanner, pool);

        // 2. 사용자 정보 입력
        Person person = InputValidator.getValidPersonInput(scanner);

        // 3. 어린이 여부
        boolean isChild = InputValidator.getIsChild(scanner);

        // 4. 강습 vs 자유 선택
        int choice = InputValidator.getValidChoice(scanner);

        // 나머지 로직은 서비스 계층을 통해 처리
        poolService.assignLane(person, isChild, choice, classLanes, freeLanes);
        scanner.close();
    }
}
