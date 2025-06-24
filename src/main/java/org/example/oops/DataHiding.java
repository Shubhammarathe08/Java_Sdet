package org.example.oops;

public class DataHiding {
    // by declaring data members as - private , we can achieve data hiding
    // keep methods accessible to outside world
    // getters and setters are used to access private data members

    private String account_holder_name;
    private double account_balance;

    public String account_holder_name() {
        return this.account_holder_name;
    }

    public double account_balance() {
        return this.account_balance;
    }

    void setAccount_balance(double balance) {
        this.account_balance = balance;
    }

    public static void main() {


    }
}
