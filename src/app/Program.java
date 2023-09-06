package app;

import entities.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int num, digitosId;

        digitosId = 9999;
        
        List<Account> list = new ArrayList<>();

        System.out.print("How many accounts will be registered? ");
        num = sc.nextInt();

        for (int i = 0; i < num; i++) {

            System.out.println();
            System.out.println("Account #" + (i + 1) + ": ");
            int id = (int) (Math.random() * digitosId);
            while (hasId(list, id)) {
                id = (int) (Math.random() * digitosId);
            }
            System.out.println("Account ID: #" + id);
            System.out.print("Holder name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Account account = new Account(id, name, salary);

            list.add(account);
        }

        System.out.println();
        System.out.println("Enter the account ID that will have salary increase: ");
        int idIncreaseSalary = sc.nextInt();

//        Integer pos = position(list, idIncreaseSalary);
        Account acc = list.stream().filter(x -> x.getAccountNumber() == idIncreaseSalary).findFirst().orElse(null);

        if (acc == null) {
            System.out.println("This ID does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            acc.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of accounts:");
        for (Account account : list) {
            System.out.println(account);
        }

        sc.close();
    }

    public static boolean hasId(List<Account> list, int id) {
        Account acc = list.stream().filter(x -> x.getAccountNumber() == id).findFirst().orElse(null);
        return acc != null;
    }

    public static Integer position(List<Account> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccountNumber() == id) {
                return i;
            }
        }
        return null;
    }
}
