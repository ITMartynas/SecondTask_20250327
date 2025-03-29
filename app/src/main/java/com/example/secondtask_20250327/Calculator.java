package com.example.secondtask_20250327;

//creating new class for calculation functionality
public class Calculator {
    public static int countWords(String text){
        //checking if the text is empty
        if (text.isEmpty()){
            return 0;
        }
        //splitting the text into an array of words based on whitespace
        //"\\s+" is a regular expression that matches any sequence of one or more whitespace characters
        String[] words = text.split("\\s+");
        return words.length; //return the length of words in array using length property
    }

    public static int countCharacters(String text){
        //checking if the text is empty
        if (text.isEmpty()){
            return 0;
        }
        return text.length(); //return the length of text characters using built-in length method.
}}
