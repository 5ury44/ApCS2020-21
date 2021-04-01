public class SelectionStatistics {
    Statistics statistics = new Statistics();
    SelectionSort sort = new SelectionSort();
    public void quarterStats(StudentInfo[] student){
        Comparable[] comp = new Comparable[student.length*4];
        for(int i=0; i<student.length;i++){
            comp[i*4]=student[i].q1;
            comp[i*4+1]=student[i].q2;
            comp[i*4+2]=student[i].q3;
            comp[i*4+3]=student[i].q4;
        }
        comp=sort.sortComp(comp);
        System.out.println("mean "+statistics.mean(comp));
        System.out.println("std dev "+statistics.stdDev(comp));
        System.out.println("median "+statistics.median(comp));
        statistics.mode(comp);
    }
}
