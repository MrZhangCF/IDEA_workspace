package com.zhangcf.hashmap;

import java.util.HashMap;
import java.util.Map;

class Student{
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17; //任意素数
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Student)obj).name) && (this.age == ((Student)obj).age);
    }
}

public class HashMapTest {
    public static void main(String[] args) {
        Student student = new Student("jack",23);

        Map<Student, Integer> map = new HashMap<>();
        map.put(student, 1);

        System.out.println(map.get(new Student("jack",23)));
    }
}
