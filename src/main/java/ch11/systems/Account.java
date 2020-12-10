package ch11.systems;

public class Account {

    int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        }
        balance = balance - amount;
        return true;
    }
}