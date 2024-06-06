# Priority Queue
## Table Of Contents:
1. [Introduction](#introduction)

## Introduction
- Priority Queues implement `heaps` internally.
- It is called PQ because the top element is always the priority element (i.e) if implemented `min heap` then the top is always minimum element and vice versa for `max heap`.
- We can use the `PriorityQueue` from the `collections` library.  

### Declaration of PQ:
```java
    PriorityQueue<Integer> pq = new PriorityQueue<>();
``` 
- By default the PQ implements `min heap`  

## Basic Operations:
1. **add()** :  
We can use the `add()` function to add a value to the PQ.
```java
pq.add(2);
pq.add(3);
pq.add(1);
``` 
While adding each element the PQ gets heapified which keeps the minimum element at the top always.  

2. **remove()**:  
It is used to delete and return value from the top.
```java
pq.delete(2);
pq.delete(3);
``` 
After every remove() operation the PQ gets heapified.

3. **peek()**:  
Return the value at the top of the queue. 

## Understand `Comparator`:
`Comparator` is a class used to compare the values in a collection.  

- When we use .sort() function in an ArrayList, it uses the method `compare` in the `Comparator` class to compare the values.  
- The `compare` method return `-1` if small, `1` if big and `0` if equal.  
- Even in PQ the values gets arranged in a heap manner by using this operation.  
## To implement a max heap `PRIORITY QUEUE`:
```java
 PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
```  
The method `reverseOrder()` will reverse the PQ resulting in a `max heap`.  

## Overriding `Comparator` class:
- The `Comparator` knows to compare `int`, `String`, `double` etc.  
- But say if there exists a class called `Student`  
```java
    public static class Student{
    String name;
    int rollno;
    int marks;
    String dob;
}
```  
- Now we want a PQ for the class Student  
```java
    PriorityQueue<Student> spq = new PriorityQueue<>();
```  
- Now on what basis will the PQ compare the Students?  
- Yes, we have to define on what basis the PQ is gonna compare the Students.  
- Inorder to do that we need to override the `Comparator` class.  
```java
private static class StudentComparator implements Comparator<Student>{
        @Override
        public int compare(Student s1, Student s2) {
            if(s1.marks > s2.marks) return 1;
            else if(s1.marks < s2.marks) return -1;
            else return 0;
        }
    }
```  
- Here we arranging the values based on student marks  
```java
PriorityQueue<Student> studentPQ = new PriorityQueue<>(new StudentComparator());
        Student s1 = new Student("Sandesh", 100, 98, "10-02-2002");
        Student s2 = new Student("Sam", 11, 87, "12-05-2002");
        Student s3 = new Student("Ram", 10, 91, "2-08-2001");

        studentPQ.add(s1);
        studentPQ.add(s2);
        studentPQ.add(s3);

        System.out.println(studentPQ.peek().name);
```  
output: Sam  

- If you need max heap condition then you can change the `compare` function in the `Comparator`
```java
private static class StudentComparator implements Comparator<Student>{
        @Override
        public int compare(Student s1, Student s2) {
            if(s1.marks > s2.marks) return -1;
            else if(s1.marks < s2.marks) return 1;
            else return 0;
        }
    }
```   

### The equal case:  
- The top element is based on the comparison of the custom parameter. In the above case it is `marks` .  
- But say if marks of all the 3 students are equal, it returns the value which was added first.  
- We can change the `compare` function in such a way that, when the marks are equal then compare based on **rollno**. (rollno can never be same) 
```java
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

    PriorityQueue<Student> studentPQ = new PriorityQueue<>(new StudentComparator());
    Student s1 = new Student("Sandesh", 100, 98, "10-02-2002");
    Student s2 = new Student("Sam", 11, 91, "12-05-2002");
    Student s3 = new Student("Ram", 10, 91, "2-08-2001");

        studentPQ.add(s1);
                studentPQ.add(s2);
                studentPQ.add(s3);

                System.out.println(studentPQ.peek().name);
```   
Output: Ram  

- So here we have defined our priority as **"if not marks then roll no"**.
