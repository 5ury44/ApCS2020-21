import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class ParseCalc {
    public void calculate(List<String> Elements, List<String> oppList){
        Elements.removeAll(Collections.singleton(""));
        for(int i=0;i< oppList.size();i++){
            if(oppList.get(i).equals("*")||oppList.get(i).equals("/")||oppList.get(i).equals("Ng")||oppList.get(i).equals("Neg")){
                try {
                    double temp = Double.parseDouble(Elements.get(i-1));
                    switch (oppList.get(i)) {
                        case "/" -> {
                            if(Double.parseDouble(Elements.get(i))==0){
                                System.out.println("There was a division error.");
                                System.exit(0);
                            }
                            temp /= Double.parseDouble(Elements.get(i));
                        }
                        case "*" -> temp *= Double.parseDouble(Elements.get(i));
                        case "Neg" -> temp *= -1 * Double.parseDouble(Elements.get(i));
                        case "Ng" -> {
                            if(Double.parseDouble(Elements.get(i))==0){
                                System.out.println("There was a division error.");
                                System.exit(0);
                            }
                            temp /= -1 * Double.parseDouble(Elements.get(i));
                        }
                    }
                    Elements.set(i-1, String.valueOf(temp));
                    Elements.remove(i);
                    oppList.remove(i);
                    i--;
                }catch (Exception e){}
            }
        }
        double result;
        if(oppList.get(0).equals("-")){result = Double.parseDouble(Elements.get(0))*-1;}
        else{result = Double.parseDouble(Elements.get(0));}
        oppList.remove(0);
        Elements.remove(0);
        int z=0;
        for (String element : Elements) {
            try {
                switch (oppList.get(z)) {
                    case "+" -> result += Double.parseDouble(element);
                    case "-" -> result -= Double.parseDouble(element);
                }
                z++;
            } catch (Exception e) {}
        }
        DecimalFormat f = new DecimalFormat("##.##########");
        System.out.println(f.format(result));
    }
}
