import java.util.Scanner;

public class PeopleSearch {
    public static person[] resize(person[] p){
        person[] persons = new person[p.length+1];
        for(int i=0; i<p.length;i++){
            persons[i]=p[i];
        }
        return persons;
    }
    public static void main(String[] args) {
        PeopleSearchSort ss = new PeopleSearchSort();
        person[] people = new person[0];
        Scanner scanner = new Scanner(System.in);
        try{
            while (true) {
                System.out.println("E=enter new person, D=Edit person, P=Print alphabetically, S=Search Sequentially, B=Binary Search");
                String st = scanner.nextLine();
                if (st.equals("E")) {
                    people = resize(people);
                    System.out.println("enter the name");
                    String name = scanner.nextLine();
                    System.out.println("enter the age");
                    int age = Integer.parseInt(scanner.nextLine());
                    person p = new person(age, name);
                    people[people.length - 1] = p;
                    ss.sort(people);
                } else if (st.equals("D")) {
                    System.out.println("What's the name of the person you want to edit");
                    String name = scanner.nextLine();
                    for (int i = 0; i < people.length; i++) {
                        if (people[i].name.equals(name)) {
                            System.out.println("What do you want to change n=name, a=age");
                            String in = scanner.nextLine();
                            if (in.equals("n")) {
                                System.out.println("enter new name");
                                people[i].name = scanner.nextLine();
                            } else {
                                System.out.println("enter new age");
                                people[i].age = Integer.parseInt(scanner.nextLine());
                            }
                        }
                    }
                } else if (st.equals("P")) {
                    for (person per : people) {
                        System.out.println(per.name + " " + per.age);
                    }
                } else if (st.equals("S")) {
                    System.out.println("enter name");
                    int x = ss.Seqsearch(scanner.nextLine(), people);
                    System.out.println(x);
                } else if (st.equals("B")) {
                    System.out.println("enter name");
                    int x = ss.BinarySearch(people, scanner.nextLine());
                    if (x == -1) {
                        System.out.println("not found");
                    } else {
                        System.out.println(people[x].name + " " + people[x].age);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("not found");
            e.printStackTrace();
        }
    }
}
