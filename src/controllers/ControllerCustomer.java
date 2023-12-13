package controllers;

import domain.interfaces.Book;
import domain.interfaces.Customer;
import domain.interfaces.Subscribe;
import services.intefaces.CustomerService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ControllerCustomer {

    private CustomerService service;

    public ControllerCustomer(CustomerService service) {
        this.service = service;
    }

    public void addCustomer() {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя клиента: ");
            String name = scanner.nextLine();
            System.out.println("Введите id подписки: ");
            int subscribeId = Integer.parseInt(scanner.nextLine());
            service.addCustomer(name, subscribeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addBookToCustomerCart() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер клиента: ");
            int clientNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите id книги: ");
            int bookId = Integer.parseInt(scanner.nextLine());
            service.addBookToCustomerCart(clientNumber, bookId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getCustomerCart() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id клиента: ");
            int customerId = Integer.parseInt(scanner.nextLine());
            return service.getCustomerCart(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isCustomerCartEmpty() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id клиента: ");
            int customerId = Integer.parseInt(scanner.nextLine());
            return service.isCustomerCartEmpty(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void clearCustomerCart() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id клиента: ");
            int customerId = Integer.parseInt(scanner.nextLine());
            service.clearCustomerCart(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isCustomerSubscribed() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id клиента: ");
            int customerId = Integer.parseInt(scanner.nextLine());
            return service.isCustomerSubscribed(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void subscribeCustomer() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id клиента: ");
            int customerId = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите название подписки:  ");
            int subscribeId =Integer.parseInt(scanner.nextLine());
            service.subscribeCustomer(customerId, subscribeId );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void unsubscribeCustomer() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id клиента: ");
            int customerId = Integer.parseInt(scanner.nextLine());
            service.unsubscribeCustomer(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double getRemainingSubscriptionTerm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id клиента: ");
            int customerId = Integer.parseInt(scanner.nextLine());
           return service.getRemainingSubscriptionTerm(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getListSubscribedCustomer() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id подписки: ");
            int subscribeId = Integer.parseInt(scanner.nextLine());
           return service.getListSubscribedCustomer(subscribeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

