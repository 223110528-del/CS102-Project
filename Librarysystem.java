/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library;

/**
 *
 * @author 223110528
 */
import java.util.Scanner;

public class Librarysystem {
    private static Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample data
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Brave New World", "Aldous Huxley", 1932);
        Member member1 = new Member("John Doe", "M001");

        library.addBook(book1);
        library.addBook(book2);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    borrowBook(scanner, member1);
                    break;
                case 4:
                    returnBook(scanner, member1);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // consume newline

        Book book = new Book(title, author, year);
        library.addBook(book);
        System.out.println("Book added: " + book);
    }

    private static void borrowBook(Scanner scanner, Member member) {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        for (Book book : library.books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                library.borrowBook(member, book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void returnBook(Scanner scanner, Member member) {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        for (Book book : library.memberLoans.get(member)) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                library.returnBook(member, book);
                return;
            }
        }
        System.out.println("Book not found in member's borrowed list.");
    }
}
