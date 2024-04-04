import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    public static void Command(){
        System.out.println("************************************");
        System.out.println("(A)dd");
        System.out.println("(D)elete");
        System.out.println("(E)mail Search");
        System.out.println("(P)rint List");
        System.out.println("(S)earch");
        System.out.println("(Q)uit");
        System.out.println("************************************");
    }

    public static void AddPerson(LinkedList contact,Scanner input){
        System.out.println("Name: ");
        contact.add(input.nextLine());
        System.out.println("Email: ");
        contact.add(input.nextLine());
        System.out.println("Phone Number: ");
        contact.add(input.nextLine());
    }

    public static void DeletePerson(LinkedList contact, Scanner input){
        System.out.println("Delete person (name): ");
        String nameD = input.nextLine();
        int x = contact.indexOf(nameD);
        for(int i=0;i<3;i++){
            contact.remove(x);
        }
    }

    public static void PrintAll(LinkedList contact){
        int n = contact.size()/3;
        int x = 0;
        for(int i=1;i<n+1;i++){
            System.out.println("###########################################");
            System.out.println("Person "+i);
            System.out.println("Name: "+contact.get(x));
            x++;
            System.out.println("Email: "+contact.get(x));
            x++;
            System.out.println("Phone Number: "+contact.get(x));
            x++;
            System.out.println("###########################################");
        }
    }

    public static void EmailSearch(LinkedList contact, Scanner input){
        System.out.println("Email search: ");
        String email = input.nextLine();
        int x = contact.indexOf(email);

        System.out.println("###########################################");
        System.out.println("Name: "+contact.get(x-1));
        System.out.println("Email: "+contact.get(x));
        System.out.println("Phone Number: "+contact.get(x+1));
        System.out.println("###########################################");
    }

    public static void Search(LinkedList contact, Scanner input){
        System.out.println("Search: ");
        String searchKey = input.nextLine();
        int x = contact.indexOf(searchKey);

        if(searchKey.matches("[0-9]+")){
            x-=2;
        }

        System.out.println("###########################################");
        System.out.println("Name: "+contact.get(x));
        System.out.println("Email: "+contact.get(x+1));
        System.out.println("Phone Number: "+contact.get(x+2));
        System.out.println("###########################################");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String task = "";
        LinkedList<String> contact = new LinkedList<String>();

        while(!task.equalsIgnoreCase("Q")){
            Command();
            System.out.println("Please enter a command: ");
            task = input.nextLine().toLowerCase();

            switch(task){
                case "a":
                    AddPerson(contact,input);
                    System.out.println("Added successfully!");
                    break;
                case "d":
                    DeletePerson(contact,input);
                    System.out.println("Deleted successfully!");
                    break;
                case "p":
                    PrintAll(contact);
                    break;
                case "e":
                    EmailSearch(contact,input);
                    break;
                case "s":
                    Search(contact,input);
                    break;
            }
        }
        System.out.println("System ended!");
    }
}