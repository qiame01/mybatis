package com.uuu;

public class Clerk {
    private String id;
    private String clerkName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "id='" + id + '\'' +
                ", clerkName='" + clerkName + '\'' +
                '}';
    }
}