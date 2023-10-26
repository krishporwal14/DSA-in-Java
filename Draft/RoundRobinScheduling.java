import queueAndStack.MyQueue;

import java.util.Scanner;
/**
 * @author Krish Porwal
 * @version 1.0.0
 * @since 17-09-2023
 */
/**
 * Class to represent a single process or task which will be processed by the processor.
 */
class Process {
    String name;
    int burstTime;
    /**
     * Constructor to initialize the process
     * @param name
     * @param burstTime
     */
    public Process(String name, int burstTime) {
        this.name = name;
        this.burstTime = burstTime;
    }
    /**
     * @return Name of the process
     */
    public String getName() {
        return name;
    }
    /**
     * @return Burst time of the process
     */
    public int getBurstTime() {
        return burstTime;
    }
    /**
     * Executes the process. This indicates the processor is scheduled for this process
     * @param timeSlice
     */
    public void execute(int timeSlice) {
        if(burstTime <= timeSlice) {
            System.out.println(name + " is executing for " + burstTime + " units.");
            burstTime = 0;
        }
        else {
            System.out.println(name + " is executing for " + timeSlice + " units.");
            burstTime -= timeSlice;
        }
    }
    /**
     * @return whether the process is finished or not
     */
    public boolean isFinished() {
        return burstTime == 0;
    }
}
/**
 * This class implements Round Robin Scheduling using Queue implementation
 */
public class RoundRobinScheduling {
    /**
     * Main method which inputs processes from user andpushes them onto queue to implement round robin scheduling
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int timeSlice, numberOfProcesses, timeReq;
        String task;
        System.out.println("Enter the number of processes: ");
        numberOfProcesses = scan.nextInt();
        System.out.println("Enter time slice: ");
        timeSlice = scan.nextInt();
        MyQueue<Process> queue = new MyQueue<>(numberOfProcesses);
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Enter the process name: ");
            task = scan.nextLine();
            System.out.println("Enter burst time of " + task + ": ");
            timeReq = Integer.parseInt(scan.nextLine());
            queue.enqueue(new Process(task, timeReq));
        }
        while(!queue.isEmpty()) {
            Process current = queue.dequeue();
            current.execute(timeSlice);
            if(current.isFinished()) continue;
            queue.enqueue(current);
        }
        scan.close();
    }
}
