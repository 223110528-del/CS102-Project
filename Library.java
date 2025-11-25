/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author 223110528
 */

import java.util.*;
public class Library {
    public ArrayList<Book> books;
    public HashMap<Member, ArrayList<Book>> memberLoans;

    public Library() {
        books = new ArrayList<>();
        memberLoans = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(Member member, Book book) {
        if (books.contains(book)) {
            books.remove(book);

            memberLoans.putIfAbsent(member, new ArrayList<>());
            memberLoans.get(member).add(book);
            System.out.println(member.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(Member member, Book book) {
        if (memberLoans.containsKey(member) && memberLoans.get(member).contains(book)) {
            memberLoans.get(member).remove(book);
            books.add(book);
            System.out.println(member.getName() + " returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }
}
