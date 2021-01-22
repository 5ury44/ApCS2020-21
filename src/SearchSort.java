import java.util.List;

public class SearchSort {
     int binarySearch(List<Book> arr, String str){
        int  s = arr.size() - 1;
        int lowPnt = 0; //binary search by checking relative value based on pointer position till found
        while (lowPnt <= s) {
            int curr = lowPnt + (s - lowPnt) / 2;
            int relPos = str.compareTo(arr.get(curr).title);
            if (relPos == 0) return curr;
            else if (relPos > 0) lowPnt = curr + 1;
            else s = curr - 1;
        }
        return -1;
    }
    public void sort(List<Book> a){
        int len = a.size();
        for(int i=0; i<len; i++){ //selection sort so everything left of pointer is sorted
            int min =i;
            for(int j=i+1; j<len;j++){
                if(less(a.get(j).title,a.get(min).title)) min =j;
            }
            exch(a,i,min);
        }
    }
    private boolean less(String v, String w){return v.compareTo(w)<0;}
    private void exch(List<Book> a, int i, int j){
        Book t=a.get(i);
        a.set(i,a.get(j)); //exchange two values
        a.set(j,t);
    }
}
