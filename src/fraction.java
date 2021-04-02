public class fraction implements number {
    private int numerator, denom;
    public fraction(int n, int d){
        this.numerator= n;
        if(d!=0){this.denom = d;}
        else{
            System.out.println("0 error. Quitting.");
            System.exit(0);
        }
    }
    public int numer(){return numerator;}
    public int den(){return denom;}
    private int LCM(int num, int de){
        int lcm;
        if(de>num){lcm = de;}
        else{lcm = num;}
        while(true) {
            if(lcm % num == 0 && lcm % de == 0) {return lcm;}
            ++lcm;
        }
    }
    private int GCF(int num, int de){
        int gcf=1;
        for(int i = 2; i <= de && i <= num; i++){if(num%i==0 && de%i==0){gcf=i;}}
        return gcf;
    }
    public void print(){
        if(numerator==0){System.out.println("0");}
        else if(denom==1){System.out.println(numerator);}
        else if(denom==numerator){System.out.println(1);}
        else if(denom==-1*numerator){System.out.println(-1);}
        else{System.out.println(numerator+"/"+denom);}
    }
    @Override
    public number add(number num) {
        if(num instanceof fraction) {
            int lcm = LCM(denom, ((fraction) num).denom);
            ((fraction) num).numerator *= lcm / ((fraction) num).denom;
            ((fraction) num).denom = lcm;
            ((fraction) num).numerator += numerator * (lcm / denom);
        }
        return num;
    }

    @Override
    public number subtract(number num) {
        if(num instanceof fraction) {
            int lcm = LCM(denom,((fraction) num).denom);
            ((fraction) num).numerator*=-1*lcm/((fraction) num).denom;
            ((fraction) num).denom=lcm;
            ((fraction) num).numerator+=numerator*(lcm/denom);
        }
        return num;
    }

    @Override
    public number multiply(number num) {
        if(num instanceof fraction) {
            ((fraction) num).numerator *= numerator;
            ((fraction) num).denom *= denom;
            int gc = GCF(((fraction) num).numerator,((fraction) num).denom);
            ((fraction) num).numerator/=gc;
            ((fraction) num).denom/=gc;
        }
        return num;
    }

    @Override
    public number divide(number num) {
        if(num instanceof fraction) {
            ((fraction) num).numerator *= denom;
            ((fraction) num).denom *= numerator;
            int gc=GCF(((fraction) num).numerator,((fraction) num).denom);
            ((fraction) num).numerator/=gc;
            ((fraction) num).denom/=gc;
        }
        return num;
    }
}
