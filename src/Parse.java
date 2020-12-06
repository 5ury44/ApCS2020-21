import java.util.*;

public class Parse {
    static class equalException extends Exception{public equalException(String x){super(x);}} //create a new custom exception
    static class noExpressionException extends Exception{public noExpressionException(String x){super(x);}}
    static ArrayList<String> split(String str, ArrayList<String> del){
        ArrayList<String> result = new ArrayList<>(Arrays.asList(""));
        for (int i = 0; i < str.length(); i++){if(!del.contains(Character.toString(str.charAt(i))))result.add(Character.toString(str.charAt(i)));} //alternative for split
        return result;
    }
    public static void main(String[] args) {
        Set<String> signs = new HashSet<>(Arrays.asList("+","-","*","/","="));
        try {
            ParseCalc parse = new ParseCalc();
            List<String> oppList = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("please enter the expression");
            String input = scanner.nextLine();
            List<String> elementsExp = Parse.split(input, new ArrayList<>(Arrays.asList("-","+","=","*","/"))); //input splitting w/out signs
            List<String> Elements = Parse.split(input, new ArrayList<>(Arrays.asList(""))); //input split w/ all signs
            Elements.remove(0);
            if(!Elements.get(0).equals("=")){throw new equalException(input);}
            if(elementsExp.size()<=2){throw new noExpressionException(input);} //check for errors of no expression or no equal sign
            for(int i=1; i<Elements.size();i++){
                if((Elements.get(i-1).equals("*")&&Elements.get(i).equals("-"))){Elements.set(i,"Neg"); Elements.remove(i-1);}
                else if((Elements.get(i-1).equals("/")&&Elements.get(i).equals("-"))){Elements.set(i,"Ng"); Elements.remove(i-1);}
                else if((Elements.get(i-1).equals("-")&&Elements.get(i).equals("-"))){Elements.set(i,"+"); Elements.remove(i-1);} //replace +-, --, *-, or /- with a single sign
                else if((Elements.get(i-1).equals("+")&&Elements.get(i).equals("-"))){Elements.set(i,"-"); Elements.remove(i-1);}
            }
            for(int i=1; i<Elements.size();i++){
                if(signs.contains(Elements.get(i))&&(signs.contains(Elements.get(i-1))||i==Elements.size()-1)){
                    if(((Elements.get(i).equals("-"))&&Elements.get(i-1).equals("="))){continue;} //check if not expression
                    throw new noExpressionException(input);
                }
            }
            if(!Elements.get(1).equals("+")&&!Elements.get(1).equals("-")){oppList.add("+");}
            for(String s:Elements){
                try{Double.parseDouble(s);}
                catch(Exception e){
                    if(signs.contains(s)||s.equals("Neg")||s.equals("Ng")){oppList.add(s);}  //add to operation list
                    else if(!s.equals(".")){throw new noExpressionException(input);}
            }
            }
            oppList.remove("=");
            parse.calculate(elementsExp,oppList); //calculate with numbers and signs lists
            scanner.close();
        }
        catch(equalException e){System.out.print(e.getMessage()+": no equal sign.");}
        catch(noExpressionException e){System.out.print(e.getMessage()+" is not a valid expression.");} //print statements when exceptions caught
        catch(Exception e){System.out.println("Encountered an error.");}
    }
}
