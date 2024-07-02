import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("D://FirstTask-StringRevApplication//StringRevApp//string.txt");
            BufferedReader  bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("D://FirstTask-StringRevApplication//StringRevApp//reversed_string.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter)){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" "); // Split by whitespace (space, tab, etc.)
                StringBuilder reversedLine = new StringBuilder();
                for (String word : words) {
                    String reversedWord = reverseString(word);
                    reversedLine.append(reversedWord).append(" ");
                }
                printWriter.println(reversedLine.toString().trim());
            }
            System.out.println("Reversing and writing to file completed ");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static String reverseString(String str) {

        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if(chars[end]>=65&&chars[end]<=90||chars[end]>=97&&chars[end]<=122){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;}
            end--;
        }
        return new String(chars);
    }
}