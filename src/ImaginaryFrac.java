public class ImaginaryFrac implements number{
    int nr, dr, ni, di;
    public ImaginaryFrac(int numreal, int denomreal, int numim, int denim){
        this.nr= numreal;
        this.ni=numim;
        if(denomreal!=0&&denim!=0){this.dr = denomreal; this.di=denim;}
        else{
            System.out.println("0 error. Quitting.");
            System.exit(0);
        }
    }
    public void print(){
        if(nr==0&&ni==0){
            System.out.println("0");
        }
        else if(nr==0){System.out.println(ni+"/"+di+"i");}
        else if(ni==0){System.out.println(nr+"/"+dr);}
        else{System.out.println(nr+"/"+dr+" "+ni+"/"+di+"i");}
    }
    @Override
    public number add(number num) {
        if(num instanceof ImaginaryFrac){
            fraction real = new fraction(((ImaginaryFrac) num).nr,((ImaginaryFrac) num).dr);
            fraction real1 = new fraction(nr,dr);
            fraction im = new fraction(((ImaginaryFrac) num).ni,((ImaginaryFrac) num).di);
            fraction im1 = new fraction(ni,di);
            fraction f = (fraction) real.add(real1);
            fraction fq = (fraction) im.add(im1);
            ImaginaryFrac ret = new ImaginaryFrac(f.numer(),f.den(),fq.numer(),fq.den());
            return ret;
        }
        return null;
    }

    @Override
    public number subtract(number num) {
        if(num instanceof ImaginaryFrac){
            fraction real = new fraction(((ImaginaryFrac) num).nr,((ImaginaryFrac) num).dr);
            fraction real1 = new fraction(nr,dr);
            fraction im = new fraction(((ImaginaryFrac) num).ni,((ImaginaryFrac) num).di);
            fraction im1 = new fraction(ni,di);
            fraction f = (fraction) real.subtract(real1);
            fraction fq = (fraction) im.subtract(im1);
            ImaginaryFrac ret = new ImaginaryFrac(f.numer(),f.den(),fq.numer(),fq.den());
            return ret;
        }
        return null;
    }

    @Override
    public number multiply(number num) {
        if(num instanceof ImaginaryFrac){
            fraction real = new fraction(((ImaginaryFrac) num).nr,((ImaginaryFrac) num).dr);
            fraction real1 = new fraction(nr,dr);
            fraction im = new fraction(((ImaginaryFrac) num).ni,((ImaginaryFrac) num).di);
            fraction im1 = new fraction(ni,di);
            fraction realresult=(fraction)((real1.multiply(real)).subtract(im1.multiply(im)));
            fraction imresult = (fraction)((real.multiply(im)).add(real1.multiply(im)));
            ImaginaryFrac f = new ImaginaryFrac(realresult.numer(),realresult.den(),imresult.numer(), imresult.numer());
            return f;
        }
        return null;
    }

    @Override
    public number divide(number num) {
        if(num instanceof ImaginaryFrac) {
            fraction real = new fraction(((ImaginaryFrac) num).nr, ((ImaginaryFrac) num).dr);
            fraction real1 = new fraction(nr, dr);
            fraction im = new fraction(((ImaginaryFrac) num).ni, ((ImaginaryFrac) num).di);
            fraction im1 = new fraction(ni, di);
            fraction d = (fraction) (real.multiply(real)).add(im.multiply(im));
            fraction realresult = (fraction)((real1.multiply(real)).subtract(real1.multiply(im1))).divide(d);
            fraction imresult = (fraction)((im1.multiply(im)).subtract(real1.multiply(im))).divide(d);
            return new ImaginaryFrac(realresult.numer(),realresult.den(),imresult.numer(), imresult.numer());
        }
        return null;
    }
}


