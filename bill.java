import java.util.*;
public class bill {
    public static void main(String args[]){
        int lunch=2500;
        int movie=1000;
        int tea=750;
        List<String> persons=new ArrayList<>();
        persons.add("balaji");
        persons.add("anand");
        persons.add("chaitanya");
        persons.add("divya");
       
        //Amount paid by persons
        HashMap<String,Integer> paid=new LinkedHashMap<>();
        paid.put("balaji",2500);
        paid.put("anand",1000);
        paid.put("chaitanya",750);
        paid.put("divya",0);

        //No.of parties persons attended->to calculate share
        HashMap<String,Integer> attend=new LinkedHashMap<>();
        attend.put("balaji",4);
        attend.put("anand",4);
        attend.put("chaitanya",4);
        attend.put("divya",3);

       //to calculate each person share in total bill
       //and balance they need to pay to each other
        HashMap<String,Integer> personshare=new LinkedHashMap<>();
        HashMap<String,Integer> balance=new LinkedHashMap<>();
       int share=0;
       for(int i=0;i<4;i++){
        String y=persons.get(i);
        //if attended for all 4 parties then share
        if(attend.get(y)==4){
            
            share=movie/4+lunch/4+tea/3;
            personshare.put(persons.get(i),share);
            int bal=share-paid.get(y);
            if(bal>0){
                balance.put(persons.get(i),bal);
                
            }
            else{
                balance.put(persons.get(i),0);
            }
        }
        //if attended only for 3 parties
        else{
            share=movie/4+lunch/4;
            personshare.put(persons.get(i),share);
            balance.put(persons.get(i),share-paid.get(y));
        }
       }
       
        
       System.out.println("Amount paid for each sevice:");
       System.out.println("LUNCH:"+lunch);
       System.out.println("MOVIE TICKET:"+movie);
       System.out.println("TEA/COFFEE:"+tea);
       System.out.println("-------------------------------");

       System.out.println("Amount paid by each indvidual\n"+paid);
       System.out.println("-------------------------------");
       System.out.println("Share of an each individual is:\n"+personshare);
       System.out.println("----------------------------------");
       System.out.println("Balance need to be paid by individual:\n"+balance);
       System.out.println("----------------------------------");
       
       System.out.println("Amount to pay or receive:\n");
       for (String person1 : paid.keySet()) {
        for (String person2 : paid.keySet()) {
            if (!person1.equals(person2)) {
    
                int amount1 = paid.get(person1);
                int amount2 = paid.get(person2);
                int diff = amount1 - amount2;
                if (diff > 0) {
                     System.out.println(person1 + " needs to receive " + diff + " from "+ person2);
                }
                 else if (diff < 0) {
                      System.out.println(person1 + " needs to pay " + (-diff) + " to " + person2);
                }
            }
        }
    }
   
   


       
       


    }
    
}
