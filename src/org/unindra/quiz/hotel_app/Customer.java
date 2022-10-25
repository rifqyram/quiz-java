package org.unindra.quiz.hotel_app;

public class Customer {
    private String name;
    private String mobilePhone;

    public Customer(String name, String mobilePhone) {
        this.name = name;
        this.mobilePhone = mobilePhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return String.format("Customer: Name=%s, Mobile Phone=%s", name, mobilePhone);
    }
}
