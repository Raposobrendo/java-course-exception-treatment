package Exercise.model.entities;

import Exercise.model.exceptions.ExerciseExceptions;

public class Account {


    private Integer accountNumber;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){

    }

    public Account(Integer accountNumber, String holder, Double balance, Double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount) throws ExerciseExceptions {
        if(amount > withdrawLimit){
            throw new ExerciseExceptions("The amount exceeds withdraw limit.");
        }
        if(amount < 0){
            throw new ExerciseExceptions("Withdraw amount must be positive.");
        }
        if(amount > balance){
            throw new ExerciseExceptions("Not enough balance.");
        }


        balance -= amount;
    }
}
