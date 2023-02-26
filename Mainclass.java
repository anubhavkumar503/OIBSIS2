import java.util.*;
public class Mainclass {

     
    public static void main(String[] args) {
        HashMap<Integer,Integer> database=new HashMap<>();
        // Object Creation
        ATMOperationinterface opinterface=new ATMOperation();

        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("Welcome to ATM interface");
        System.out.println("Tap :\n1.For Login\n2.For Create new Account\n3.For Exit.");
        int acc=sc.nextInt();
        if(acc==1){   
        System.out.println("Enter ATM Account Number : ");
        int accno=sc.nextInt();
        System.out.println("Enter the Password : ");
        int pin=sc.nextInt();
        if(database.containsKey(accno)){
        if(pin==database.get(accno)){
               help();
            } } 
            else{System.out.println("\nInvalid ATM Password. Try to Login Again Or Create Account!!");
        }
        }
        else if(acc==2){
            int user_acc_no=1+(int)(100000*Math.random());
            System.out.println("Your Account Number is : "+user_acc_no);
            System.out.println("Create or Enter Password");
            int user_pass=sc.nextInt();
            database.put(user_acc_no,user_pass);
            System.out.println("Enter the Cash You want to Deposit.\nNote : Minimum Deposit Amount Should be 1000.0");
            Double user_cash=sc.nextDouble();
            opinterface.DepositAmount(user_cash);
            help();
        }
    
    else if(acc==3){
        System.out.println("ThankYour for using the ATM interface\n");
        break;
    }}
    
    
    } 
public static void help(){
    ATMOperationinterface opinterface=new ATMOperation();
    Scanner sc=new Scanner(System.in);
    while(true){
        System.out.println("\n1.View Current Balance\n2.Withdraw Cash\n3.Deposit Cash\n4.View Statemnet\n5.For Exit.");
        int choice=sc.nextInt();
       if(choice==1){
            opinterface.viewbalance(); }
            else if(choice==2){
              System.out.println("Enter Amount to be Withdraw : ");
              double withdraw=sc.nextDouble();
              opinterface.withdrawAmount(withdraw);
            }
            else if(choice==3){
            System.out.println("Enter Amount to be Deposit");
            Double deposit_amout=sc.nextDouble();
            opinterface.DepositAmount(deposit_amout); }
           else if(choice==4){
            System.out.println("Statement is Given below:\n");
            opinterface.viewministatement();
           }
            else if(choice==5){  System.out.println("ThankYour for using the ATM interface\n");
            break;}
            else{ System.out.println("\nEnter Valid Choice");}
        }
}
}
