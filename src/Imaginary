public class Imaginary implements number{
    private double real, imaginary;
    public Imaginary(double n, double i){
        this.real=n;
        this.imaginary=i;
    }
    public void print(){
        if(real==0&&imaginary==0){System.out.println("0");}
        else if(real==0){System.out.println(imaginary+" i");}
        else if(imaginary==0){System.out.println(real);}
        else{System.out.println(real+" + ("+imaginary+"i)");}
    }
    @Override
    public number add(number num) {
        if(num instanceof Imaginary){
            ((Imaginary) num).real += real;
            ((Imaginary) num).imaginary += imaginary;
        }
        return num;
    }

    @Override
    public number subtract(number num) {
        if(num instanceof Imaginary){
            ((Imaginary) num).real = -1* ((Imaginary) num).real+real;
            ((Imaginary) num).imaginary = -1* ((Imaginary) num).imaginary+imaginary;;
        }
        return num;
    }

    @Override
    public number multiply(number num) {
        if(num instanceof Imaginary){
            double num1 = ((Imaginary) num).real;
            double im1 = ((Imaginary) num).imaginary;
            ((Imaginary) num).real=num1*real-im1*imaginary;
            ((Imaginary) num).imaginary=num1*imaginary+real*im1;
        }
        return num;
    }

    @Override
    public number divide(number num) {
        if(num instanceof Imaginary){
            Imaginary im = new Imaginary(real,imaginary);
            double d = (Math.pow(((Imaginary) num).real,2)-(-1*Math.pow(((Imaginary) num).imaginary,2)));
            System.out.println((im.real*((Imaginary) num).real));
            im.real=((im.real*((Imaginary) num).real)-(im.imaginary*-1*((Imaginary) num).imaginary))/d;

            im.imaginary=((imaginary*((Imaginary) num).real)+(-1*real*((Imaginary) num).imaginary))/d;

            return im;
        }

        return null;
    }
}
