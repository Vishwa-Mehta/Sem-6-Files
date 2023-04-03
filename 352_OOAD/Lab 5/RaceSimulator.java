import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RaceSimulator {
    public static void main(String[] args) {
        int numRunners = 5; // default number of runners
        if (args.length > 0) {
            numRunners = Integer.parseInt(args[0]);
        }
        List<Runner> runners = new ArrayList<>();
        for (int i = 1; i <= numRunners; i++) {
            runners.add(new Runner("Runner " + i));
        }
        for (Runner runner : runners) {
            runner.start(); // start each runner thread
        }
        try {
            for (Runner runner : runners) {
                runner.join(); // wait for each runner to finish
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Collections.sort(runners, Collections.reverseOrder()); // sort runners by distance covered
        System.out.println("Top 3 runners:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + runners.get(i));
        }
    }
}

class Runner extends Thread implements Comparable<Runner> {
    private static final int DISTANCE_TARGET = 1000;
    private static final int MIN_DISTANCE = 5;
    private static final int MAX_DISTANCE = 10;
    private static final Random random = new Random();
    private final String name;
    private int distanceCovered;

    public Runner(String name) {
        this.name = name;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    @Override
    public void run() {
        while (distanceCovered < DISTANCE_TARGET) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int distanceThisSecond = random.nextInt(MAX_DISTANCE - MIN_DISTANCE + 1) + MIN_DISTANCE;
            distanceCovered += distanceThisSecond;
            System.out.println(name + " covered " + distanceThisSecond + " meters, total: " + distanceCovered);
        }
    }

    @Override
    public int compareTo(Runner other) {
        return Integer.compare(distanceCovered, other.distanceCovered);
    }

    @Override
    public String toString() {
        return name + " (" + distanceCovered + "m)";
    }
}
