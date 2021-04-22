package com.company.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TransactionDetails {

    HashMap<String, ArrayList<Transactions>> everydayTransaction = new HashMap<>();
    ArrayList<Transactions> transit;
    float total = 0;
    Scanner sc = new Scanner(System.in);

    //adding transactions
    public void add(Transactions transactions){
        //getting date,month,year
        LocalDate localDate = LocalDate.parse(transactions.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();

        if(everydayTransaction.containsKey(key)){
            everydayTransaction.get(key).add(transactions);
            total = 0;
            for(int i =0;i<everydayTransaction.get(key).size();i++){
                total = total + everydayTransaction.get(key).get(i).income + everydayTransaction.get(key).get(i).expense;
            }
        }
        else{
            transit = new ArrayList<>();
            transit.add(transactions);
            everydayTransaction.put(key,transit);
            total = transactions.expense+transactions.income;
        }
        System.out.println(total);
    }

    public void edit(Transactions transactions){
        LocalDate localDate = LocalDate.parse(transactions.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();
        if (everydayTransaction.get(key).contains(transactions)) {
            //Entering new details
            System.out.println("Enter new Expense");
            float exp = sc.nextFloat();
            System.out.println("Enter new Income");
            float inc = sc.nextFloat();
            System.out.println("Enter new date(yyyy MM dd)");
            String date = sc.next();

            Transactions transactions1 = new Transactions(date,exp,inc);
            //getting index of the element which is going to be edited
            int x = everydayTransaction.get(key).indexOf(transactions);
            //replacing old transaction with the edited one
            everydayTransaction.get(key).set(x,transactions1);
        }
        else{
            System.out.println("This transaction is not present");
        }
    }

    public void delete(Transactions transactions){
        LocalDate localDate = LocalDate.parse(transactions.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();
        if(everydayTransaction.containsKey(key)){
            if(everydayTransaction.get(key).contains(transactions)){
                //removing the transaction
                everydayTransaction.get(key).remove(transactions);
            }
            else{
                System.out.println("The given transaction doesn't exist");
            }
        }
        else{
            System.out.println("The given transaction doesn't exist");
        }
    }

    public void monthSummary(String month,int year){
        String key = month + " " + year;
        System.out.println("\nThe summary of the entered month is - ");

        if(everydayTransaction.containsKey(key)){
            float totalExpense = 0;
            float totalIncome = 0;
            total = 0;
            for(int i =0;i<everydayTransaction.get(key).size();i++){
                totalExpense = everydayTransaction.get(key).get(i).expense;
                totalIncome = everydayTransaction.get(key).get(i).income;
                total = total + everydayTransaction.get(key).get(i).income + everydayTransaction.get(key).get(i).expense;
                System.out.println("Expense - "+totalExpense+"    Income - "+totalIncome+"     Date - "
                        +everydayTransaction.get(key).get(i).date);
            }

            System.out.println("Total transaction this month is - "+total);
        }
    }

    //getting the details of all the months
    public void allMonthsDetails(){
        System.out.println("\n");
        for(String key1 : everydayTransaction.keySet()){
            System.out.println(key1);

            total=0;
            for(int i =0;i<everydayTransaction.get(key1).size();i++){
                total = total + everydayTransaction.get(key1).get(i).income + everydayTransaction.get(key1).get(i).expense;
            }

            System.out.println("Total transaction this month is - "+total);
        }
    }

    //getting detail of a particular date
    /*public void detail(String date){
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();
        int y = localDate.getDayOfMonth();

        //checking if given date exist or not
        int x = everydayTransaction.get(key).indexOf(y);
        if(x == -1){
            System.out.println("No transaction made");
        }
        float expense = everydayTransaction.get(key).get(y).expense;
        System.out.println("Expense on "+date+" = "+expense);
        float income = everydayTransaction.get(key).get(y).income;
        System.out.println("Income on "+date+" = "+income);
        total = 0;
        total = expense+income;
        System.out.println("Total on "+date+" = "+total);
    }*/
}
