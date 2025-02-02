import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pool pool = new Pool(6, 22);  // 개장 시간: 6시, 폐장 시간: 22시
        int openingTime = pool.getOpeningTime();
        int closingTime = pool.getClosingTime();

        // 레인 목록: 경력순 ascending
        List<ClassLane> classLanes = new ArrayList<>();
        classLanes.add(new ClassLane(openingTime, closingTime, 1, 25, 0, "어린이", 0, true));
        classLanes.add(new ClassLane(openingTime, closingTime, 2, 25, 1.2, "초급", 1, false));
        classLanes.add(new ClassLane(openingTime, closingTime, 3, 25, 1.2, "중급", 3, false));
        classLanes.add(new ClassLane(openingTime, closingTime, 4, 50, 1.4, "상급", 6, false));
        classLanes.add(new ClassLane(openingTime, closingTime, 5, 50, 1.4, "마스터", 12, false));

        List<FreeLane> freeLanes = new ArrayList<>();
        freeLanes.add(new FreeLane(openingTime, closingTime, 6, 25, 1.2, 1, false));
        freeLanes.add(new FreeLane(openingTime, closingTime, 7, 25, 1.2, 3, false));
        freeLanes.add(new FreeLane(openingTime, closingTime, 8, 25, 1.2, 6, false));
        freeLanes.add(new FreeLane(openingTime, closingTime, 9, 50, 1.4, 12, false));
        freeLanes.add(new FreeLane(openingTime, closingTime, 10, 50, 1.4, 12, true));

        // 안내 문구 출력
        Guide guide = new Guide();
        guide.printStartGuide();
        guide.printLaneList(classLanes, freeLanes);

        // 1. 이용 시간 입력
        System.out.print("\n몇 시에 이용할 예정인가요? (숫자만 입력하세요.) ");
        int time = scanner.nextInt();
        if (!pool.isOpen(time)) {
            System.out.println("이용 가능 시간이 아닙니다. 프로그램을 다시 실행해주세요.");
            return;
        }
        else {
            System.out.println("이용 가능합니다.");
        }

        // 사용자 정보 입력
        System.out.print("\n이름을 입력하세요: ");
        String name = scanner.next();
        System.out.print("\n수영 경력(개월)을 입력하세요: ");
        int experience = scanner.nextInt();

        Person person = new Person(name, experience);

        // 2. 어린이 여부
        System.out.print("\n어린이인가요? (Yes: 1, No: 0) ");
        int isChild = scanner.nextInt();

        // 어린이라면 어린이 대상 강습 레인으로 배정
        if (isChild == 1) {
            for (ClassLane lane : classLanes) {
                if (lane.assignChildLane(person)) return;
            }
            System.out.println("배정 가능한 어린이 레인이 없습니다. 프로그램을 다시 실행해주세요.");
            return;
        }

        // 3. 강습 vs 자유 선택
        System.out.print("\n강습 레인(1) 또는 자유 레인(2)을 선택하세요: ");
        int choice = scanner.nextInt();

        if (choice == 1) { // 강습 레인 선택
            for (int i = 0; i < classLanes.size(); i++) {
                ClassLane currentLane = classLanes.get(i);

                // 어린이 레인이 아닌 레인에서만 실행
                if (!currentLane.getIsChildLane()){

                    // 지금 레인의 요구 경력 <= 이용자의 경력 < 다음 레인의 요구 경력일 때만 배정
                    if (person.getExp() >= currentLane.getMinExp()) {
                        if (i == classLanes.size() - 1 || person.getExp() < classLanes.get(i + 1).getMinExp()) {
                            currentLane.assignLane(person);
                            return;
                        }
                    }
                }
            }
            System.out.println("배정 가능한 강습 레인이 없습니다. 프로그램을 다시 실행해주세요.");
            return;
        }

        if (choice == 2) { // 자유 레인 선택
            System.out.print("\n핀을 사용하시겠습니까? (Yes: 1, No: 0) ");
            int wantsFin = scanner.nextInt();

            if (wantsFin == 1) {
                for (FreeLane lane : freeLanes) {
                    if (lane.assignFinLane(person)) return;
                }
                System.out.println("배정 가능한 핀 자유 레인이 없습니다. 프로그램을 다시 실행해주세요.");
                return;
            }

            for (int i = 0; i < freeLanes.size(); i++) {
                FreeLane currentLane = freeLanes.get(i);

                // 핀 레인이 아닌 레인에서만 실행
                if (!currentLane.getUseFin()){

                    // 지금 레인의 요구 경력 <= 이용자의 경력 < 다음 레인의 요구 경력일 때만 배정
                    if (person.getExp() >= currentLane.getMinExp()) {
                        if (i == freeLanes.size() - 1 || person.getExp() < freeLanes.get(i + 1).getMinExp()) {
                            currentLane.assignLane(person);
                            return;
                        }
                    }
                }
            }
            System.out.println("배정 가능한 자유 레인이 없습니다. 프로그램을 다시 실행해주세요.");
            return;
        }

        scanner.close();
    }
}