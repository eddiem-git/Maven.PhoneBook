package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private final Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this.map = new TreeMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumberList = new ArrayList<>();
        if (hasEntry(name)) {
            phoneNumberList = lookup(name);
        }
        phoneNumberList.add(phoneNumber);
        map.put(name, phoneNumberList);
    }

    public void addAll(String name, String... phoneNumbers) {
        for(String phoneNumber : phoneNumbers) {
            add(name, phoneNumber);
        }
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        Set<String> contactNames = map.keySet();
        return contactNames.contains(name);
    }

    public List<String> lookup(String name) {
        List<String> result = map.get(name);
        return result;
    }


    public String reverseLookup(String phoneNumber) {
        Set<String> contactNames = map.keySet();
        for(String contactName : contactNames) {
            List<String> phoneNumbers = map.get(contactName);
            if(phoneNumbers.contains(phoneNumber)) {
                return contactName;
            }
        }
        return null;
    }


    public String reverseLookup2(String phoneNumber) {
       Set<Map.Entry<String, List<String>>> entries = map.entrySet();
       for(Map.Entry<String, List<String>> entry : entries){
           String key = entry.getKey();
           List<String> value = entry.getValue();
           if(value.contains(phoneNumber)) {
               return key;
           }
       }
       return null;
    }

    public List<String> getAllContactNames() {
        List<String> result = new ArrayList<>();
        map.keySet().forEach(result::add);
        return result;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
