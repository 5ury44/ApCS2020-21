import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class statsMain {
    public static void main(String[] args) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        Statistics stats = new Statistics();
        String[] nums;
        Comparable[] cnums = new Comparable[0];
        InsertionSort Sort = new InsertionSort();
        try{
            while (true) {
                System.out.println("choose an option: s=show, i=insert list and sort, a=add number, m=mean, mde=mode, med=median, std=std dev, clear=clear");
                String in = br.readLine();
                if (in.equals("i")) {
                    System.out.println("enter the string of numbers to sort");
                    nums = br.readLine().split(",");
                    if (nums.length > 25) {
                        System.out.println("Error");
                        System.exit(0);
                    }
                    cnums = new Comparable[nums.length];
                    for (int i = 0; i < nums.length; i++) {
                        cnums[i] = Integer.parseInt(nums[i]);
                    }
                    Sort.sort(cnums);
                } else if (in.equals("s")) {
                    Sort.show(cnums);
                } else if (in.equals("a")) {
                    System.out.println("enter number");
                    int addition = Integer.parseInt(br.readLine());
                    if (cnums.length < 25) {
                        Comparable[] temp = new Comparable[cnums.length + 1];
                        for (int i = 0; i < cnums.length; i++) {
                            temp[i] = cnums[i];
                        }
                        temp[cnums.length] = addition;
                        cnums = temp;
                        Sort.sort(cnums);
                    } else {
                        System.out.println("cannot add");
                    }
                } else if (in.equals("m")&&cnums.length!=0) {
                    double d = stats.mean(cnums);
                    System.out.println(d);
                } else if (in.equals("clear")) {
                    cnums = new Comparable[0];
                } else if (in.equals("med")&&cnums.length!=0) {
                    double d = stats.median(cnums);
                    System.out.println(d);
                } else if (in.equals("std")&&cnums.length!=0) {
                    double d = stats.stdDev(cnums);
                    System.out.println(d);
                } else if (in.equals("mde")&&cnums.length!=0) {
                    stats.mode(cnums);

                } else {
                    System.out.println("Quitting...");
                    System.exit(0);
                }
            }
        }catch(Exception e){
            System.out.println("error");
            e.printStackTrace();
        }

    }
}
