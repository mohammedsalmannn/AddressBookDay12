package com.bridgelabz;

import java.util.*;


public class AddressService implements IAddress {

    ArrayList<AddressGetterSetter> book = new ArrayList<>();
    HashMap<String, String> citydict = new HashMap<String, String>();
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
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getFname().equals(Info.getFname())) {
                if (book.get(i).getLname().equals(Info.getLname())) {
                    System.out.println("Duplicate");
                    break;
                }
            } else
                book.add(Info);
        }
        if (book.size() == 0)
            book.add(Info);

    }


    @Override
    public void Edit() {

        String temp = null;
        System.out.println("Enter the Phone number of the record u want to Edit");
        temp = s.next();
        if (book.isEmpty()) {
            System.out.println("No records to edit");
            return;
        }

        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getPhone().equals(temp)) {
                AddressGetterSetter Info = new AddressGetterSetter();
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

        String temp = null;
        System.out.println("Enter the First name of the record you want to delete");
        temp = s.next();
        if (book.isEmpty()) {
            System.out.println("No records to delete");
            return;
        }
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getFname().equals(temp)) {
                book.remove(i);
                break;
            }
        }
    }

    @Override
    public void SortName() {

    }

    @Override
    public void SortCity() {
        Collections.sort(book, AddressGetterSetter.CityComparator);
    }

    @Override
    public void SortState() {

    }


    @Override
    public void DisplayCity() {

        Set set = citydict.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("City is: " + mentry.getKey() + " & Name is: ");
            System.out.println(mentry.getValue());
        }
    }




    @Override
    public void Search() {
        System.out.println("Search Preferance:1.City  2.State");
        int input = s.nextInt();
        if (input == 1) {
            String temp = null;
            System.out.println("Enter the City whose record u want to display");
            temp = s.next();
            if (book.isEmpty()) {
                System.out.println("No records to Show");
                return;
            }

            for (int i = 0; i < book.size(); i++) {
                if (book.get(i).getCity().equals(temp)) {
                    System.out.println(book.get(i).getFname());
                }
            }
        } else {
            String temp = null;
            System.out.println("Enter the State whose record u want to display");
            temp = s.next();
            if (book.isEmpty()) {
                System.out.println("No records to Show");
                return;
            }

            for (int i = 0; i < book.size(); i++) {
                if (book.get(i).getState().equals(temp)) {
                    System.out.println(book.get(i).getFname());
                }
            }
        }


    }

}