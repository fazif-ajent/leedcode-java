import java.util.concurrent.locks.ReentrantLock;

public class Thediningphilo {

    private ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        if (left < right) {
            forks[left].lock();
            forks[right].lock();
        } else {
            forks[right].lock();
            forks[left].lock();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putRightFork.run();
        putLeftFork.run();

        forks[left].unlock();
        forks[right].unlock();
    }
}