package ejb.model;

@EntityBlaBla
@Table(name = "CustomerService")
public class CustomerService {  
      private long id;
      private String name;
      private String openTime;
      private String closeTime;
      private String address;
      private String telephone;
      private Integer capacity;
      private String owner;
      private String averageWaitingTime;
      private Set<Appointment> apointments = new HashSet<Appointment>();
      private Category category;

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
      
      public String getOpenTime(){
           return openTime;
      }
      
      public void setOpenTime(String openTime){
           this.openTime = openTime;
      }
      
      public String getCloseTime(){
           return closeTime;
      }
      
      public void setCloseTime(String closeTime){
           this.closeTime = closeTime;
      }
      
      public String getAddress(){
           return address;
      }
      
      public void setAddress(String address){
           this.address = address;
      }
      
      public String getTelephone(){
           return telephone;
      }
      
      public void setTelephone(String telephone){
           this.telephone = telephone;
      }
      
      public Integer getCapacity(){
           return capacity;
      }
      
      public void setCapacity(Integer capacity){
           this.capacity = capacity;
      }
      
      public String getOwner(){
           return owner;
      }
      
      public void setOwner(String owner){
           this.owner = owner;
      }
      
      public String getAverageWaitingTime(){
           return averageWaitingTime;
      }
      
      public void setAverageWaitingTime(String averageWaitingTime){
           this.averageWaitingTime = averageWaitingTime;
      }
      
      public Set<Appointment> getApointments(){
           return apointments;
      }
      
      public void setApointments( Set<Appointment> apointments){
           this.apointments = apointments;
      }
      
      public Category getCategory(){
           return category;
      }
      
      public void setCategory(Category category){
           this.category = category;
      }
      

}
