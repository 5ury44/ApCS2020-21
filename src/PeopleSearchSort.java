public class PeopleSearchSort {
    public static void sort(person[] a){
        int len = a.length;
        for(int i=0; i<len; i++){
            int min =i;
            for(int j=i+1; j<len;j++){
                if(less(a[j],a[min])) min =j;
            }
            exch(a,i,min);
        }
    }
    private static boolean less(person v, person w){
        return v.name.compareTo(w.name)<0;
    }
    private static void exch(person[]a, int i, int j){
        person t =a[i];
        a[i] =a[j];
        a[j]=t;
    }
    public static int Seqsearch(String Name, person[] Names){
        int compares =0;
        for(person p: Names){
            if(p.name.equals(Name)){
                System.out.println("found:"+p.name+" "+p.age+" with "+compares);
                return compares;
            }
            compares++;
        }
        System.out.println("Not Found "+ compares);
        return compares;
    }
    public static int BinarySearch(person[] Names, String Name){
        int compares=0;
        int left=0;
        int right=Names.length-1;
        while(left<=right){
            int currMid = left+(right-left)/2;
            int y =Name.compareTo(Names[currMid].name);
            if(y==0){
                System.out.println("compares:"+compares);
                return currMid;
            }
            if(y>0){
                left=currMid+1;
                compares++;
            }
            else{
                right=currMid-1;
                compares++;
            }
            System.out.println(left+" "+right);
        }
        System.out.println("compares:"+compares);
        return -1;
    }
}
