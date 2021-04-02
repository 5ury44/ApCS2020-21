import java.util.*;

public class calcMain {
    static ArrayList<String> split(String str, ArrayList<String> del){
        ArrayList<String> result = new ArrayList<>();
        String s="";
        String s1 = "";
        int i;
        for ( i = 0; i < str.length(); i++){
            if(del.contains(Character.toString(str.charAt(i)))){break;}
            else if(!Character.isWhitespace((str.charAt(i))))s+=(Character.toString(str.charAt(i)));
        }
        result.add(s);
        for (int i1=i+1;i1 < str.length(); i1++){
            if(!Character.isWhitespace((str.charAt(i1))))s1+=(Character.toString(str.charAt(i1)));
        }
        result.add(s1);
        return result;
    }
    static String sign(String str){
        for (int i = 0; i < str.length(); i++){
            if(Character.toString(str.charAt(i)).equals("s")){return "s";}
            else if(Character.toString(str.charAt(i)).equals("a")){return "a";}
            else if(Character.toString(str.charAt(i)).equals("m")){return "m";}
        }
        return "d";
    }
    static boolean negative(String str){
        for (int i = 0; i < str.length(); i++){
            if(Character.toString(str.charAt(i)).equals("-")){return true;}
        }
        return false;
    }
    static String removeI(String s){
        String newS = "";
        for (int i = 0; i < s.length(); i++){
            if(!Character.toString(s.charAt(i)).equals("i")){newS+=Character.toString(s.charAt(i));}
        }
        return newS;
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Type I for imaginary, IF for Imaginary w/ fractions, and F for fractions, Q is quit");
                String in = scanner.nextLine();
                if(in.equals("Q")){System.exit(0);}
                else if (in.equals("F")) {
                    System.out.println("Please enter in this format '1/2s1/2' with no spaces - s,a,m,d are the operations");
                    ArrayList<String> del = new ArrayList<String>(Arrays.asList("s", "a", "m", "d"));
                    String ex = scanner.nextLine();
                    ArrayList<String> expression = split(ex, del);
                    System.out.println(expression);
                    fraction f = new fraction(Integer.parseInt(split(expression.get(0), new ArrayList<String>(Arrays.asList("/"))).get(0)), Integer.parseInt(split(expression.get(0), new ArrayList<String>(Arrays.asList("/"))).get(1)));
                    fraction f1 = new fraction(Integer.parseInt(split(expression.get(1), new ArrayList<String>(Arrays.asList("/"))).get(0)), Integer.parseInt(split(expression.get(1), new ArrayList<String>(Arrays.asList("/"))).get(1)));
                    String sign = sign(ex);
                    if (sign.equals("s")) {
                        ((fraction) f.subtract(f1)).print();
                    } else if (sign.equals("a")) {
                        ((fraction) f1.add(f)).print();
                    } else if (sign.equals("m")) {
                        ((fraction) f1.multiply(f)).print();
                    } else {
                        ((fraction) f1.divide(f)).print();
                    }
                } else if (in.equals("IF")) {
                    System.out.println("Please enter in this format '1/2+3/2is1/2-3/2i' with no spaces- s,a,m,d are the operations");
                    ArrayList<String> del = new ArrayList<String>(Arrays.asList("s", "a", "m", "d"));
                    String ex = scanner.nextLine();
                    ArrayList<String> expression = split(ex, del);
                    System.out.println(expression);
                    int si = 1, si1 = 1;
                    if (negative(expression.get(0))) {
                        si = -1;
                    }
                    if (negative(expression.get(1))) {
                        si1 = -1;
                    }
                    int z = +1;
                    int z1 = 1;
                    if (expression.get(0).charAt(0) == '-') {
                        z = -1;
                        String s = expression.get(0);
                        expression.set(0, s.substring(1));
                    }
                    if (expression.get(1).charAt(0) == '-') {
                        z1 = -1;
                        String s = expression.get(1);
                        System.out.println(s);
                        expression.set(1, s.substring(1));
                    }

                    ImaginaryFrac imaginary = new ImaginaryFrac(z * Integer.parseInt(expression.get(0).split("\\+|-")[0].split("/")[0]), Integer.parseInt(expression.get(0).split("\\+|-")[0].split("/")[1]), si * Integer.parseInt(expression.get(0).split("\\+|-")[1].split("/")[0]), Integer.parseInt(removeI(expression.get(0).split("\\+|-")[1].split("/")[1])));
                    ImaginaryFrac imaginary1 = new ImaginaryFrac(z1 * Integer.parseInt(expression.get(1).split("\\+|-")[0].split("/")[0]), Integer.parseInt(expression.get(1).split("\\+|-")[0].split("/")[1]), si1 * Integer.parseInt(expression.get(1).split("\\+|-")[1].split("/")[0]), Integer.parseInt(removeI(expression.get(1).split("\\+|-")[1].split("/")[1])));
                    String sign = sign(ex);
                    if (sign.equals("s")) {
                        System.out.println("ss");
                        ((ImaginaryFrac) imaginary.subtract(imaginary1)).print();
                    } else if (sign.equals("a")) {
                        ((ImaginaryFrac) imaginary1.add(imaginary)).print();
                    } else if (sign.equals("m")) {
                        ((ImaginaryFrac) imaginary.multiply(imaginary1)).print();
                    } else if (sign.equals("d")) {
                        ((ImaginaryFrac) imaginary1.divide(imaginary)).print();
                    }
                    //fix negative sign in beginning of each real piece
                } else {
                    System.out.println("Please enter in this format '1+3is1-3i' with no spaces- s,a,m,d are the operations");
                    ArrayList<String> del = new ArrayList<String>(Arrays.asList("s", "a", "m", "d"));
                    String ex = scanner.nextLine();
                    ArrayList<String> expression = split(ex, del);
                    System.out.println(expression);
                    int si = 1, si1 = 1;
                    if (negative(expression.get(0))) {
                        si = -1;
                    }
                    if (negative(expression.get(1))) {
                        si1 = -1;
                    }
                    int z = +1;
                    int z1 = 1;
                    if (expression.get(0).charAt(0) == '-') {
                        z = -1;
                        String s = expression.get(0);
                        expression.set(0, s.substring(1));
                    }
                    if (expression.get(1).charAt(0) == '-') {
                        z1 = -1;
                        String s = expression.get(1);
                        System.out.println(s);
                        expression.set(1, s.substring(1));
                    }
                    Imaginary imaginary = new Imaginary(z * Integer.parseInt(split(expression.get(0), new ArrayList<String>(Arrays.asList("+", "-"))).get(0)), Integer.parseInt(removeI(split(expression.get(0), new ArrayList<String>(Arrays.asList("+", "-"))).get(1))) * si);
                    Imaginary imaginary1 = new Imaginary(z1 * Integer.parseInt(split(expression.get(1), new ArrayList<String>(Arrays.asList("+", "-"))).get(0)), Integer.parseInt(removeI(split(expression.get(1), new ArrayList<String>(Arrays.asList("+", "-"))).get(1))) * si1);
                    String sign = sign(ex);
                    if (sign.equals("s")) {
                        ((Imaginary) imaginary.subtract(imaginary1)).print();
                    } else if (sign.equals("a")) {
                        ((Imaginary) imaginary.add(imaginary1)).print();
                    } else if (sign.equals("m")) {
                        ((Imaginary) imaginary.multiply(imaginary1)).print();
                    } else if (sign.equals("d")) {
                        ((Imaginary) imaginary.divide(imaginary1)).print();
                    }
                }
        }
        }catch(Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
    }
}

