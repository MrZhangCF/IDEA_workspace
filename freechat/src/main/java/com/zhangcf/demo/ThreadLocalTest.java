package com.zhangcf.demo;

import java.util.Random;

class Student{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ThreadLocalTest implements Runnable{

    private final static ThreadLocal studentLocal = new ThreadLocal();
    private Student student = new Student();
    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        Thread t1 = new Thread(test,"t1");
        Thread t2 = new Thread(test,"t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        accessStudent();
    }

    private synchronized void accessStudent() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("thread " + currentThreadName + " set age to: " + age);
        //Student student = getStudent();
        student.setAge(age);
        System.out.println("thread " + currentThreadName +
        " first read age is: " + student.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread " + currentThreadName + " second read age is: " + student.getAge());
    }

    private Student getStudent() {
//        Student student = (Student) studentLocal.get();
//        if (student == null){
//            student = new Student();
//            studentLocal.set(student);
//        }
        Student student = new Student();
        //studentLocal.set(student);
        return student;
    }
}
