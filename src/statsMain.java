import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class statsMain {
    public static void main(String[] args) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        System.out.println("enter the string of numbers to sort");
        String[] nums = br.readLine().split(",");
        ArrayList<String> SList = new ArrayList<>(nums.length);
        for (String i : nums){SList.add(i);}
        Sort sort = new Sort();
        ArrayList<Integer> L= sort.insertionSort(SList);

    }
}
