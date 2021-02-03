import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Characters {
    static String[] split(String str){
        String[] temp = new String[str.length()];
        String tempStr = "";
        int counter= 0;
        for(int i=0; i<temp.length;i++){
            if(!Character.isWhitespace((str.charAt(i)))){tempStr+=str.charAt(i);}
            else if(Character.isWhitespace((str.charAt(i)))){temp[counter]=tempStr;counter++;tempStr="";}
        }
        temp[counter]=tempStr;
        return temp;
    }
    static void Punctuation(String[] input){
        Set<String> punc = new HashSet<>(Arrays.asList(";","!",",",".",":","?"));
        int totalCharacters=0, counter=0;
        String[] wordLen = new String[input.length];
        int[] numLen = new int[input.length];
        for(String word:input){
            if(word!=null&& !word.equals("") &&!Character.isWhitespace(word.charAt(0))){
                if(punc.contains(Character.toString(word.charAt(word.length()-1)))&&word.length()!=1){
                    String temporary = "";
                    for(int i=0; i<word.length()-1;i++){temporary+=word.charAt(i);}
                    counter = goCounter(counter, wordLen, numLen, temporary);
                }
                else{counter = goCounter(counter, wordLen, numLen, word);}
                totalCharacters+= word.length();
            }
        }
        Vowel(totalCharacters,wordLen,numLen);
    }
    private static int goCounter(int counter, String[] wordLen, int[] numLen, String word) {
        for(int j=1; j<wordLen.length;j++){
            if(wordLen[j]!=null&&word.equals(wordLen[j])){numLen[j]+=1; break;}
            else if((wordLen[j]==null)){
                counter++;
                wordLen[counter]=word;
                numLen[counter]=1;
                break;
        }
    }
        return counter;
    }
    static void Vowel(int characters, String[] Words, int[] Numbers){
        Set<String> vowels = new HashSet<>(Arrays.asList("a","e","i","o","u"));
        Set<String> consonants = new HashSet<>(Arrays.asList("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "x","y","z"));
        System.out.println("Total Characters: "+ characters);
        int vow=0, cons=0, others=0;
        for(int j=0; j<Words.length;j++){
            if(Words[j]!=null){
                System.out.println(Words[j]+" - "+Numbers[j]);
                for(int i=0; i<Words[j].length();i++){
                    if(vowels.contains(Character.toString(Words[j].charAt(i)))){vow+=Numbers[j];}
                    else if(consonants.contains(Character.toString(Words[j].charAt(i)))){cons+=Numbers[j];}
                    else {others+=Numbers[j];}
                }
            }
        }
        System.out.println("There are "+vow+" vowels, "+cons+" consonants, "+others+" special characters (not used as punctuation).");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
        Punctuation(Characters.split(input.toLowerCase()));
    }
}
