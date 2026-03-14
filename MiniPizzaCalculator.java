import java.util.Scanner;
public class pizza {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("How many people? ");
        int people=sc.nextInt();
        System.out.print("How many pizzas do you have? ");
        int pizzas=sc.nextInt();
        System.out.print("How many slices per pizza? ");
        int slices=sc.nextInt();
        int numsl=slices*pizzas;
        System.out.println(people+" people with "+pizzas+ " pizzas ("+numsl+" slices) ");
        int pieces=numsl/people;
        System.out.println("Each person gets "+pieces+" pieces of pizza. ");
        int left=numsl%people;
        if(left==0)
            System.out.println("There are 0 leftover pieces.");
        else if(left==1)
            System.out.println("Thera are ! leftover piece");
        else
            System.out.println("There are "+left+" leftover pieces.");
        System.out.println("Calculating Required Pizzas ");
        System.out.print("How many people? ");
        int people2=sc.nextInt();
        System.out.print("How many slices does each person want? ");    
        int wantedsl=sc.nextInt();
        int total=people2*wantedsl;
        int pizzaneeded=total/slices;
        System.out.println("You need to order "+pizzaneeded+" pizzas.");
    }
}
