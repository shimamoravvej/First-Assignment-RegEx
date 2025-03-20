package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Exercises {

    /*
        complete the method below, so it will validate an email address
     */
    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+[a-zA-Z0-9._%+-]+[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     */
    public String findDate(String string) {
        String datePattern = "\\b(\\d{4})[-/](\\d{1,2})[-/](\\d{1,2})\\b|\\b(\\d{1,2})[-/](\\d{1,2})[-/](\\d{4})\\b";

        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find())
        {
            String date = matcher.group();
            if (isValidDate(date))
            {
                return date;
            }
        }
        return null;
    }

    private boolean isValidDate(String date)
    {

        String[] parts = date.split("[-/]");
        int day, month, year;

        if (parts.length != 3)
        {
            return false;
        }


        if (parts[0].length() == 4)
        {
            year = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            day = Integer.parseInt(parts[2]);
        }
        else
        {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        }


        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;


        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) return false;
        if (month == 2)
        {
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) && (year % 400 == 0);
            return day <= (isLeap ? 29 : 28);
        }

        return true;

    }

    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        - at least 8 characters
        - has to include at least one uppercase letter, and at least a lowercase
        - at least one number and at least a special char "!@#$%^&*"
        - has no white-space in it
     */
    public int findValidPasswords(String string) {
        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }


    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();


        string = string.toLowerCase();


        String[] words = string.split("[^a-zA-Z]+");

        for (String word : words)
        {

            if (word.length() >= 3 && isPalindrome(word))
            {
                list.add(word);
            }
        }

        return list;
    }
    private boolean isPalindrome(String word)
    {
        int left = 0, right = word.length() - 1;
        while (left < right)
        {
            if (word.charAt(left) != word.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // you can test your code here

    }