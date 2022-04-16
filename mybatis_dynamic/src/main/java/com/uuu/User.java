package com.uuu;

public class User {
    private String id;
    private String userName;
    private String age;

    public User() {
    }

    public User(String id, String userName, String age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
