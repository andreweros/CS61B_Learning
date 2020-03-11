package proj1b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) throws IOException {
        int minLength = 4;
        BufferedReader in = new BufferedReader(new FileReader("src/proj1b/words.txt"));
        //In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        String word;
        while ((word = in.readLine()) != null) {
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
//        if(palindrome.isPalindrome(word)) System.out.println(word);
    } //Uncomment this class once you've written isPalindrome. */
}
