import java.util.HashMap;
import java.time.LocalDate; 
import java.time.LocalTime; 

public class ATMOperation implements ATMOperationinterface {
    ATM atmobj=new ATM();
    HashMap<String,Double> ministat=new HashMap<>();
    @Override
    public void viewbalance(){  
        System.out.println("Current Balance is : "+atmobj.getBalance());
    }
    @Override
    public void withdrawAmount(double withdrawamount){ 
        double currbal=atmobj.getBalance();
        if(currbal>withdrawamount){
        LocalDate date = LocalDate.now();    
        LocalTime time = LocalTime.now();
        ministat.put("Withdrawn Amount on "+date.toString()+" "+time.toString()+" is : ",withdrawamount);
        System.out.println("Withdrawn Amount is : "+withdrawamount);
        atmobj.setBalance(atmobj.getBalance()-withdrawamount);
        viewbalance(); }
        else{
            System.out.println("Insufficient Balance in Your Account !!!");
        }
     }
    @Override
    public void DepositAmount(double depositamount){ 
        LocalDate date = LocalDate.now();  
        LocalTime time = LocalTime.now();  
        ministat.put("Deposited Amount on "+date.toString()+" "+time.toString()+" is :",depositamount);
        System.out.println("Deposited Amount is : "+depositamount);
        atmobj.setBalance(atmobj.getBalance()+depositamount);
        viewbalance();
    }
    @Override
    public void viewministatement(){
        if(ministat.size()!=0){
        for(String entries:ministat.keySet()){
            System.out.println(entries+" "+ministat.get(entries));
        } }
        else{
            System.out.println("No Transactions happend so far.");
        }
      }
}
