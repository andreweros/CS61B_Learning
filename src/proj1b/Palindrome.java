package proj1b;


public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> words = new LinkedListDeque<Character>();
        for(int i = 0; i < word.length(); i++) {
            words.addLast(word.charAt(i));
        }
        return words;
    }
/* Don't use get
    public boolean isPalindrome(String word) {
        Deque<Character> words = new LinkedListDeque<Character>();
        words = wordToDeque(word);
        for(int i = 1; i <= words.size(); i++) {
            if(!words.get(i).equals(words.get(words.size() - i + 1))) {
               return false;
            }
        }
        return true;
    }
*/
    private boolean equalChar(char a, char b, CharacterComparator cc) {
        OffByOne obo = new OffByOne();
        return obo.equalChars(a,b);
    }

    private boolean preCheck(Deque words){
        if(words.size()>1&&words.removeFirst().equals(words.removeLast())) {
            preCheck(words);
        }
        if(words.size() <= 1) return true;
        else return false;
    }

    public  boolean isPalindrome(String word) {
        Deque<Character> words = new LinkedListDeque<Character>();
        words = wordToDeque(word);
        return preCheck(words);
    }

    public static void main(String[] args) {
        String word = "ababa";
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(word));
    }
}
