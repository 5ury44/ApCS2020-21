public class SelectionSort {
    public static StudentInfo[] sort(StudentInfo[] a, boolean average){
        int len = a.length;
        for(int i=0; i<len; i++){
            int min =i;
            for(int j=i+1; j<len;j++){
                if(average&&less(a[j],a[min])) min =j;
                else if(!average&&less2(a[j],a[min])) min =j;;
            }
            exch(a,i,min);
        }
        return a;
    }
    private static boolean less(StudentInfo v, StudentInfo w){
        return w.avg<v.avg;
    }
    private static boolean less2(StudentInfo v, StudentInfo w){return v.name.compareTo(w.name)<0;}
    private static void exch(StudentInfo[]a, int i, int j){
        StudentInfo t =a[i];
        a[i] =a[j];
        a[j]=t;
    }
    public static Comparable[] sortComp(Comparable[] a){
        int len = a.length;
        for(int i=0; i<len; i++){
            int min =i;
            for(int j=i+1; j<len;j++){
                if(lessComp(a[j],a[min])) min =j;
            }
            exchComp(a,i,min);
        }
        return a;
    }
    private static boolean lessComp(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exchComp(Comparable[]a, int i, int j){
        Comparable t =a[i];
        a[i] =a[j];
        a[j]=t;
    }
}

