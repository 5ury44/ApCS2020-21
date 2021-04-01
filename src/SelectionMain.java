import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionMain {

    public static StudentInfo[] resize(StudentInfo[] T){
        StudentInfo[] newArr = new StudentInfo[T.length+1];
        for(int i=0;i<T.length;i++){newArr[i]=T[i];}
        return newArr;
    }
    public static void main(String[] args) throws IOException {
        SelectionStatistics st = new SelectionStatistics();
        SelectionSort sort = new SelectionSort();
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        StudentInfo[] stu = new StudentInfo[0];
        try{
            while (stu.length < 15) {
                System.out.println("What option would you like to choose: c=create new student, s=print stats, a=print sorted by avgs, p=print sorted by name");
                String in = br.readLine();
                if (in.equals("c")) {
                    System.out.println("Enter the name of the student");
                    String name = br.readLine();
                    System.out.println("Enter the grad year of the student");
                    int grade = Integer.parseInt(br.readLine());
                    if(grade<1900||grade>2100){System.out.println("error"); continue;}
                    System.out.println("Enter quarter averages as shown: 100,100,100,100");
                    String[] avgs = br.readLine().split(",");
                    if (Integer.parseInt(avgs[0]) >= 0 && Integer.parseInt(avgs[0]) <= 100 && Integer.parseInt(avgs[1]) >= 0 && Integer.parseInt(avgs[1]) <= 100 && Integer.parseInt(avgs[2]) >= 0 && Integer.parseInt(avgs[2]) <= 100 && Integer.parseInt(avgs[3]) >= 0 && Integer.parseInt(avgs[3]) <= 100) {
                        stu = resize(stu);
                        stu[stu.length - 1] = new StudentInfo(name, Integer.parseInt(avgs[0]), Integer.parseInt(avgs[1]), Integer.parseInt(avgs[2]), Integer.parseInt(avgs[3]), grade);
                    }
                    else{System.out.println("error"); }
                } else if (in.equals("a")) {
                    stu = sort.sort(stu, true);
                    for (StudentInfo s : stu) {
                        System.out.println(s.name + " " + s.avg+" "+s.schoolClass);
                    }
                } else if (in.equals("p")) {
                    stu = sort.sort(stu, false);
                    for (StudentInfo s : stu) {
                        System.out.println(s.name + " " + s.avg+" "+s.schoolClass);
                    }
                } else if(in.equals("s")) {
                    st.quarterStats(stu);
                }
                else{System.exit(0);}
            }
        }catch (Exception e){
            System.out.println("error");
        }
    }
}

