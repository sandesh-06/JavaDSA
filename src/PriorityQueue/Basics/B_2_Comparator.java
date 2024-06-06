package PriorityQueue.Basics;

import java.util.Comparator;
import java.util.PriorityQueue;

public class B_2_Comparator {
    public static class Student{
        String name;
        int rollno;
        int marks;
        String dob;

        public Student(String n, int r, int m, String d){
            name = n;
            rollno = r;
            marks = m;
            dob = d;
        }
    }

    private static class StudentComparator implements Comparator<Student>{
        @Override
        public int compare(Student s1, Student s2) {
            if(s1.marks > s2.marks) return 1;
            else if(s1.marks < s2.marks) return -1;
            else{
                if(s1.rollno > s2.rollno) return 1;
                else if(s1.rollno < s2.rollno) return -1;
                else return 0;
            }
        }
    }
    public static void main(String[] args) {
        //1. Implementing Max heap using comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(2);
        pq.add(21);
        pq.add(12);
        pq.add(19);
//        System.out.println(pq.peek());

        //2. PQ for the class Student
        PriorityQueue<Student> studentPQ = new PriorityQueue<>(new StudentComparator());
        Student s1 = new Student("Sandesh", 100, 98, "10-02-2002");
        Student s2 = new Student("Sam", 11, 91, "12-05-2002");
        Student s3 = new Student("Ram", 10, 91, "2-08-2001");

        studentPQ.add(s1);
        studentPQ.add(s2);
        studentPQ.add(s3);

        System.out.println(studentPQ.peek().name);
    }
}
