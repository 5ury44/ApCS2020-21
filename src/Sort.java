import java.util.ArrayList;

public class Sort {
    private ArrayList<Integer> sorted = new ArrayList<>();
    public ArrayList<Integer> insertionSort(ArrayList<String> unsorted){
        for(int i=0; i<unsorted.size(); i++){
            if(i==0){sorted.add(Integer.parseInt(unsorted.get(0)));}
            else{
                for(int j=0; j<sorted.size(); j++){
                    if(Integer.parseInt(unsorted.get(i))>sorted.get(j)){
                        sorted.add(Integer.parseInt(unsorted.get(i)));
                        break;
                    }
                }
        }
    }
        return sorted;
}
}
