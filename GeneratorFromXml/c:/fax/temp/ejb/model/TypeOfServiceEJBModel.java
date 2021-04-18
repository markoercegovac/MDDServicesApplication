package ejb.model;

@EntityBlaBla
@Table(name = "TypeOfService")
public class TypeOfService {  
      private long id;
      private String name;
      private double price;
      private Appointment apointment;

      public long getId(){
           return id;
      }
      
      public void setId(long id){
           this.id = id;
      }
      
      public String getName(){
           return name;
      }
      
      public void setName(String name){
           this.name = name;
      }
      
      public double getPrice(){
           return price;
      }
      
      public void setPrice(double price){
           this.price = price;
      }
      
      public Appointment getApointment(){
           return apointment;
      }
      
      public void setApointment(Appointment apointment){
           this.apointment = apointment;
      }
      

}
