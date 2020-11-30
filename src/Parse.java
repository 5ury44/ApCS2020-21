import java.util.*;

public class Parse {
    static class equalException extends Exception{public equalException(String x){super(x);}}
    static class noExpressionException extends Exception{public noExpressionException(String x){super(x);}}
    public static void main(String[] args) {
        Set<String> signs = new HashSet<>(Arrays.asList("+","-","*","/","="));
        try {
            ParseCalc parse = new ParseCalc();
            List<String> oppList = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("please enter the expression");
            String input = scanner.nextLine();
            List<String> elementsExp = new ArrayList<>(Arrays.asList(input.split("=-|=\\+|=|\\+|-|\\*|/")));
            List<String> Elements = new ArrayList<>(Arrays.asList(input.split("")));
            if(!Elements.get(0).equals("=")){throw new equalException(input);}
            if(elementsExp.size()<=2){throw new noExpressionException(input);}
            for(int i=1; i<Elements.size();i++){
                if((Elements.get(i-1).equals("*")&&Elements.get(i).equals("-"))){Elements.set(i,"Neg"); Elements.remove(i-1);}
                if((Elements.get(i-1).equals("/")&&Elements.get(i).equals("-"))){Elements.set(i,"Ng"); Elements.remove(i-1);}
                else if(((Elements.get(i-1).equals("/")||Elements.get(i-1).equals("*"))&&Elements.get(i).equals("+"))){Elements.set(i,"*"); Elements.remove(i-1);}
            }
            for(int i=1; i<Elements.size();i++){
                if(signs.contains(Elements.get(i))&&(signs.contains(Elements.get(i-1))||i==Elements.size()-1)){
                    if(((Elements.get(i).equals("-")||Elements.get(i).equals("+"))&&Elements.get(i-1).equals("="))){continue;}
                    throw new noExpressionException(input);
                }
            }
            if(!Elements.get(1).equals("+")&&!Elements.get(1).equals("-")){oppList.add("+");}
            for(String s:Elements){
                try{Double.parseDouble(s);}
                catch(Exception e){
                    if(signs.contains(s)||s.equals("Neg")||s.equals("Ng")){oppList.add(s);}
                    else if(!s.equals(".")){throw new noExpressionException(input);}
            }
            }
            oppList.remove("=");
            parse.calculate(elementsExp,oppList);
            scanner.close();
        }
        catch(equalException e){System.out.print(e.getMessage()+": no equal sign.");}
        catch(noExpressionException e){System.out.print(e.getMessage()+" is not a valid expression.");}
        catch(Exception e){System.out.println("Encountered an error.");e.printStackTrace();}
    }
}