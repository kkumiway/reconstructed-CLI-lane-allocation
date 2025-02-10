package service;

import model.*;

import java.util.List;

public class PoolService {
    private final Pool pool;

    public PoolService(Pool pool) {
        this.pool = pool;
    }

    public List<ClassLane> getClassLanes() {
        return List.of(
                new ClassLane(pool.getOpeningTime(), pool.getClosingTime(), 1, 25, 0, "어린이", 0, true),
                new ClassLane(pool.getOpeningTime(), pool.getClosingTime(), 2, 25, 1.2, "초급", 1, false),
                new ClassLane(pool.getOpeningTime(), pool.getClosingTime(), 3, 25, 1.2, "중급", 3, false),
                new ClassLane(pool.getOpeningTime(), pool.getClosingTime(), 4, 50, 1.4, "상급", 6, false),
                new ClassLane(pool.getOpeningTime(), pool.getClosingTime(), 5, 50, 1.4, "마스터", 12, false)
        );
    }

    public List<FreeLane> getFreeLanes() {
        return List.of(
                new FreeLane(pool.getOpeningTime(), pool.getClosingTime(), 6, 25, 1.2, 1, false),
                new FreeLane(pool.getOpeningTime(), pool.getClosingTime(), 7, 25, 1.2, 3, false),
                new FreeLane(pool.getOpeningTime(), pool.getClosingTime(), 8, 25, 1.2, 6, false),
                new FreeLane(pool.getOpeningTime(), pool.getClosingTime(), 9, 50, 1.4, 12, false),
                new FreeLane(pool.getOpeningTime(), pool.getClosingTime(), 10, 50, 1.4, 12, true)
        );
    }

    public void assignLane(Person person, boolean isChild, int choice, List<ClassLane> classLanes, List<FreeLane> freeLanes) {
        // 강습 또는 자유 레인 배정 로직
        if (isChild) {
            for (ClassLane lane : classLanes) {
                if (lane.assignChildLane(person)) return;
            }
        }

        if (choice == 1) {
            for (ClassLane lane : classLanes) {
                if (person.getExp() >= lane.getMinExp()) {
                    lane.assignLane(person);
                    return;
                }
            }
        } else {
            // 자유 레인 배정
            for (FreeLane lane : freeLanes) {
                if (person.getExp() >= lane.getMinExp()) {
                    lane.assignLane(person);
                    return;
                }
            }
        }
    }
}
