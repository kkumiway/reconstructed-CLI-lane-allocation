package util;

import model.Person;
import model.Pool;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputValidator {

    public static void getValidTimeInput(Scanner scanner, Pool pool) {
        int time;
        while (true) {
            System.out.print("\n몇 시에 이용할 예정인가요? (숫자만 입력하세요.) ");
            try {
                time = scanner.nextInt();
                if (!pool.isOpen(time)) {
                    System.out.println("이용 가능 시간이 아닙니다. 다시 입력해주세요.");
                } else {
                    System.out.println("이용 가능합니다.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                scanner.next();
            }
        }
    }

    public static Person getValidPersonInput(Scanner scanner) {
        String name = "";
        while (true) {
            System.out.print("\n이름을 입력하세요: ");
            name = scanner.next();
            if (name.isEmpty()) {
                System.out.println("\n이름을 입력해주세요.");
            } else {
                break;
            }
        }

        int experience = -1;
        while (true) {
            System.out.print("\n수영 경력(개월)을 입력하세요: ");
            try {
                experience = scanner.nextInt();
                if (experience < 0) {
                    System.out.println("경력은 0개월 이상의 숫자여야 합니다.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                scanner.next();
            }
        }

        return new Person(name, experience);
    }

    public static boolean getIsChild(Scanner scanner) {
        int isChild = -1;
        while (true) {
            System.out.print("\n어린이인가요? (Yes: 1, No: 0) ");
            try {
                isChild = scanner.nextInt();
                if (isChild != 0 && isChild != 1) {
                    System.out.println("잘못된 입력입니다. 0 또는 1을 입력해주세요.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                scanner.next();
            }
        }
        return isChild == 1;
    }

    public static int getValidChoice(Scanner scanner) {
        int choice = -1;
        while (true) {
            System.out.print("\n강습 레인(1) 또는 자유 레인(2)을 선택하세요: ");
            try {
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                scanner.next();
            }
        }
        return choice;
    }

    public static boolean getUseFin(Scanner scanner) {
        int wantsFin = -1;
        while (true) {
            System.out.print("\n핀을 사용하시겠습니까? (Yes: 1, No: 0) ");
            try {
                wantsFin = scanner.nextInt();
                if (wantsFin != 0 && wantsFin != 1) { // 0 또는 1이 아닌 숫자를 입력할 경우 재입력 요구
                    System.out.println("1 또는 0만 입력해주세요.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) { // 입력값이 숫자가 아닌 경우 재입력 요구
                System.out.println("잘못된 입력입니다. 1 또는 0만 입력해주세요.");
                scanner.next();  // 잘못된 입력을 처리하기 위해 버퍼를 클리어
            }
        }
        return wantsFin == 1;
    }
}