package com.company.Model;

public class Transactions {
    String date;
    float expense,income;

    public Transactions() {
    }

    public Transactions(String date, float expense, float income) {
        this.date = date;
        this.expense = expense;
        this.income = income;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "date='" + date + '\'' +
                ", expense=" + expense +
                ", income=" + income +
                '}';
    }
}
