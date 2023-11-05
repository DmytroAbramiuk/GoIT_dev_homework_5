package org.example.entities;

import java.sql.Date;

public class Worker {
    private final String name;
    private final Date birthday;
    private final String level;
    private final int salary;

    public Worker(String name, Date birthday, String level, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getLevel() {
        return level;
    }

    public int getSalary() {
        return salary;
    }
}
