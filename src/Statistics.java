public class Statistics {
    public double mean(Comparable[] arr){
        double total=0;
        for(Comparable i:arr){
            total+=(int)i;
        }
        return total/arr.length;
    }
    public double median(Comparable[] arr){
        double median;
        if (arr.length % 2 == 0) {median = ((int)arr[arr.length/2] + (int)arr[arr.length/2 - 1])/2.0;}
        else {median = (int) arr[arr.length/2];}
        return median;
    }
    public double stdDev(Comparable[] arr){
        double mean = mean(arr);
        double total = 0;
        for(Comparable s:arr){total+=Math.abs(mean-(int)s);}
        return total/arr.length;
    }
    public void mode(Comparable[] arr){
        int mval=-1, mcount=0;
        for(int i=0;i<arr.length;i++){
            int z =0;
            for(int j=0; j< arr.length;j++){
                if(arr[i]==arr[j]){z++;}
            }
            if(z>mcount){
                mval=(int)arr[i];
                mcount=z;
            }
        }
        int prev=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int z =0;
            for(int j=0; j< arr.length;j++){
                if(arr[i]==arr[j]){z++;}
            }
            if(z==mcount&&prev!=(int)arr[i]&&mcount!=1){
                System.out.println(arr[i]);
                prev=(int)arr[i];
            }
        }
        System.out.println("All available modes have been printed.");
    }
}
