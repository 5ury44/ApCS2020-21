public abstract class fraction implements number {
    private int numerator;
    private int denom;
    public fraction(int n, int d){
        numerator= n;
        denom = d;
    }
    public double numer(){return numerator;}
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
    public number add(fraction num) {
        int lcm = LCM(denom,num.denom);
        num.numerator*=lcm/num.denom;
        num.denom=lcm;
        num.numerator+=numerator*(lcm/denom);
        return num;
    }
    public number subtract(fraction num) {
        int lcm = LCM(denom,num.denom);
        num.numerator*=-1*lcm/num.denom;
        num.denom=lcm;
        num.numerator+=numerator*(lcm/denom);
        return num;
    }
    public number multiply(fraction num) {
        num.numerator *= numerator;
        num.denom *= denom;
        num.numerator/=GCF(num.numerator,num.denom);
        num.denom/=GCF(num.numerator,num.denom);
        return num;
    }
//reverse division
    public number divide(fraction num) {
        num.numerator *= denom;
        num.denom *= numerator;
        num.numerator/=GCF(num.numerator,num.denom);
        num.denom/=GCF(num.numerator,num.denom);
        return num;
    }
}
