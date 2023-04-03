import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceSimulation {
    public static boolean isFin = false;
    private static class Runner extends Thread implements Runnable {
        private String name;
        private int distanceCovered;
        private int raceLength = 1000;
        private static Random rand = new Random();
        public Runner(String name) {
            this.name = name; 
            this.distanceCovered = 0; 
        } 
        public void run() { 
            while (distanceCovered < raceLength && isFin == false) { 
                int distance = rand.nextInt(6) + 5; 
                System.out.println(name + " has covered " + distanceCovered + " meters.");
                if (distanceCovered + distance <= raceLength) {
					distanceCovered += distance;
				}
				else {
					break;
				}
                try { 
                    Thread.sleep(1); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            }
            isFin = true;
        }
        public int getDistanceCovered() { 
            return distanceCovered; 
        }
        public final String getRunnerName() { 
            return name; 
        } 
    }
    public static void main(String[] args) throws InterruptedException {
        int numRunners = Integer.parseInt(args[0]);
        List<Thread> threads = new ArrayList<>();
        List<Runner> runners = new ArrayList<>();
        for (int i = 0; i < numRunners; i++) {
            Runner r = new Runner("Runner " + (i+1));
            Thread t = new Thread(r); 
            threads.add(t);
            runners.add(r); 
            t.start(); 
        } 
        for (Thread t : threads) { 
            t.join(); 
        } 
        System.out.println("The race has ended!"); 
        // find the top 3 runners 
        runners.sort((r1, r2) -> r2.getDistanceCovered() - r1.getDistanceCovered()); 
        // print the top 3 runners 
        System.out.println("The top 3 runners are:");
        for (int i = 0; i < 3; i++) { 
            Runner r = runners.get(i);
            System.out.println((i+1) + ". " + r.getRunnerName() + " covered " + r.getDistanceCovered() + " meters.");
        }
    } 
}
