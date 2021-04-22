package com.company;

import com.company.Model.TransactionDetails;
import com.company.Model.Transactions;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int choice;
        String date;
        float expense;
        float income;

        Scanner sc = new Scanner(System.in);
        System.out.println("**Welcome To ExpenseManager**");
        System.out.println("You have to follow the following instructions to proceed further - ");
        System.out.println("1. Press 0 if you want to add the transaction.");
        System.out.println("2. Press 1 if you want to edit any transaction.");
        System.out.println("3. Press 2 if you want to delete any transaction.");
        System.out.println("4. Press 3 and enter the month whose details you want to see.");
        System.out.println("5. Press 4 to see the details of transaction of all the months.");
        System.out.println("6. Press 5 and enter the date whose details you want to see.");
        System.out.println("7. Press 6 to exit the application.");
        System.out.println();
        System.out.println("Now You May Proceed");
        System.out.println("Enter you choice - ");
        choice = sc.nextInt();

        while(choice != 6) {

            switch (choice) {
                case 0:
                    System.out.println("Enter Date(yyyy-MM-dd) - ");
                    date = sc.next();
                    System.out.println("Enter Expense - ");
                    expense = sc.nextFloat();
                    System.out.println("Enter Income - ");
                    income = sc.nextFloat();

                    Transactions transactions = new Transactions(date,expense,income);
                    TransactionDetails transactionDetails = new TransactionDetails();
                    transactionDetails.add(transactions);
                    break;

                case 1:
                    System.out.println("Enter Date(yyyy-MM-dd) - ");
                    date = sc.next();
                    System.out.println("Enter Expense - ");
                    expense = sc.nextFloat();
                    System.out.println("Enter Income - ");
                    income = sc.nextFloat();

                    Transactions transactions1 = new Transactions(date,expense,income);
                    TransactionDetails transactionDetails1 = new TransactionDetails();
                    transactionDetails1.edit(transactions1);
                    break;

                case 2 :
                    System.out.println("Enter Date(yyyy-MM-dd) - ");
                    date = sc.next();
                    System.out.println("Enter Expense - ");
                    expense = sc.nextFloat();
                    System.out.println("Enter Income - ");
                    income = sc.nextFloat();

                    Transactions transactions2 = new Transactions(date,expense,income);
                    TransactionDetails transactionDetails2 = new TransactionDetails();
                    transactionDetails2.delete(transactions2);
                    break;

                case 3:
                    System.out.println("Enter the month whose details you want to see - ");
                    String month = sc.next();

                    System.out.println("Enter the year - ");
                    int year = sc.nextInt();

                    TransactionDetails transactionDetails3 = new TransactionDetails();
                    //getting details of particular month
                    transactionDetails3.monthSummary(month,year);

                    break;

                case 4:
                    TransactionDetails transactionDetails4 = new TransactionDetails();
                    //getting details of all the months
                    transactionDetails4.allMonthsDetails();
                    break;

                default:
                    System.out.println("Enter a valid number!");
            }

            System.out.println("Enter you choice - ");
            choice = sc.nextInt();
            }
        System.out.println("Thank you for installing our app!");
    }
}
