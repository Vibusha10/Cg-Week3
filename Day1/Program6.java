class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;

        Process temp = head, prev = null;

        if (head.pid == pid && head.next == head) {
            head = null;
            return;
        }

        if (head.pid == pid) {
            Process tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
            if (temp.pid == pid) {
                prev.next = temp.next;
                return;
            }
        } while (temp != head);
    }

    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;
        int processCount = getCount();
        Process current = head;

        System.out.println("Starting Round Robin Scheduling with Time Quantum = " + timeQuantum);
        while (completedProcesses < processCount) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                time += execTime;
                current.remainingTime -= execTime;

                if (current.remainingTime == 0) {
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;
                    System.out.println("Process " + current.pid + " completed. TAT = " + turnaroundTime + ", WT = " + waitingTime);
                    completedProcesses++;
                }
            }
            displayQueue();
            current = current.next;
        }

        System.out.println("\nAll processes completed.");
        System.out.println("Average Waiting Time: " + (float) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time: " + (float) totalTurnaroundTime / processCount);
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("[PID: " + temp.pid + ", Remaining: " + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public int getCount() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class Program6 {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 5, 1);
        scheduler.addProcess(2, 8, 2);
        scheduler.addProcess(3, 6, 1);
        scheduler.addProcess(4, 3, 3);

        scheduler.simulate(4);
    }
}