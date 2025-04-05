class Student {
    int rollNo;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    Student head;

    public void addAtBeginning(int rollNo, String name, int age, String grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNo, String name, int age, String grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    public void addAtPosition(int position, int rollNo, String name, int age, String grade) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        Student newStudent = new Student(rollNo, name, age, grade);

        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }

        Student current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of range.");
            return;
        }

        newStudent.next = current.next;
        current.next = newStudent;
    }

    public void deleteByRollNo(int rollNo) {
        Student current = head;
        Student prev = null;

        while (current != null && current.rollNo != rollNo) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
            return;
        }

        if (prev == null) {
            head = current.next;
        } else {
            prev.next = current.next;
        }

        System.out.println("Student with Roll No " + rollNo + " deleted.");
    }

    public void searchByRollNo(int rollNo) {
        Student current = head;

        while (current != null) {
            if (current.rollNo == rollNo) {
                System.out.println("Found:");
                System.out.println("Roll No: " + current.rollNo);
                System.out.println("Name   : " + current.name);
                System.out.println("Age    : " + current.age);
                System.out.println("Grade  : " + current.grade);
                return;
            }
            current = current.next;
        }

        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public void updateGradeByRollNo(int rollNo, String newGrade) {
        Student current = head;

        while (current != null) {
            if (current.rollNo == rollNo) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll No " + rollNo);
                return;
            }
            current = current.next;
        }

        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Student current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo);
            System.out.println("Name   : " + current.name);
            System.out.println("Age    : " + current.age);
            System.out.println("Grade  : " + current.grade);
            System.out.println("------------------------");
            current = current.next;
        }
    }
}

public class Program1 {
    public static void main(String[] args) {
        StudentLinkedList records = new StudentLinkedList();

        records.addAtEnd(101, "Alice", 20, "A");
        records.addAtBeginning(102, "Bob", 21, "B");
        records.addAtPosition(2, 103, "Charlie", 22, "C");

        records.displayAll();

        records.searchByRollNo(103);
        records.updateGradeByRollNo(103, "A+");
        records.deleteByRollNo(101);

        records.displayAll();
    }
}
