package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;



public class AddressService implements IAddress {
    ArrayList<AddressGetterSetter> book =new ArrayList<>();
    Scanner s = new Scanner(System.in);


    @Override
    public void Add() {

        AddressGetterSetter Info = new AddressGetterSetter();
        System.out.println("Enter First name:");
        Info.setFname(s.next());
        System.out.println("Enter last name:");
        Info.setLname(s.next());
        System.out.println("Enter your address:");
        Info.setAddress(s.next());
        System.out.println("Enter your city:");
        Info.setCity(s.next());
        System.out.println("Enter your state:");
        Info.setState(s.next());
        System.out.println("Enter your ZIP code:");
        Info.setZip(s.next());
        System.out.println("Enter your phone number");
        Info.setPhone(s.next());
        book.add(Info);

    }


    @Override
    public void Edit() {

        String temp=null;
        System.out.println("Enter the Phone number of the record u want to Edit");
        temp=s.next();
        if(book.isEmpty())
        {
            System.out.println("No records to edit");
            return;
        }

        for(int i=0;i<book.size();i++)
        {
            if(book.get(i).getPhone().equals(temp))
            {
                AddressGetterSetter Info=new AddressGetterSetter();
                System.out.println(temp);
                System.out.println("Enter First name:");
                Info.setFname(s.next());
                System.out.println("Enter last name:");
                Info.setLname(s.next());
                System.out.println("Enter your address:");
                Info.setAddress(s.next());
                System.out.println("Enter your city:");
                Info.setCity(s.next());
                System.out.println("Enter your state:");
                Info.setState(s.next());
                System.out.println("Enter your ZIP code:");
                Info.setZip(s.next());
                System.out.println("Enter your phone number");
                Info.setPhone(s.next());
                book.remove(i);
                book.add(i, Info);
                break;
            }

        }
    }


    @Override
    public void Delete() {

        String temp=null;
        System.out.println("Enter the First name of the record you want to delete");
        temp=s.next();
        if(book.isEmpty())
        {
            System.out.println("No records to delete");
            return;
        }
        for(int i=0;i<book.size();i++)
        {
            if(book.get(i).getFname().equals(temp))
            {
                book.remove(i);
                break;
            }
        }
    }

}
