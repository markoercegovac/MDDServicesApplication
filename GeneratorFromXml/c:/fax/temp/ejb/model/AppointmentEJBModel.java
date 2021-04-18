package ejb.model;

@EntityBlaBla
@Table(name = "Appointment")
public class Appointment {  
      private long id;
      private String customer;
      private String customerEmail;
      private String additionalExtraService;
      private String date;
      private String time;
      private double priceWithTaxes;
      private Set<Recension> recensions = new HashSet<Recension>();
      private Set<TypeOfService> types = new HashSet<TypeOfService>();
      private CustomerService service;

      public long getId(){
           return id;
      }
      
      public void setId(long id){
           this.id = id;
      }
      
      public String getCustomer(){
           return customer;
      }
      
      public void setCustomer(String customer){
           this.customer = customer;
      }
      
      public String getCustomerEmail(){
           return customerEmail;
      }
      
      public void setCustomerEmail(String customerEmail){
           this.customerEmail = customerEmail;
      }
      
      public String getAdditionalExtraService(){
           return additionalExtraService;
      }
      
      public void setAdditionalExtraService(String additionalExtraService){
           this.additionalExtraService = additionalExtraService;
      }
      
      public String getDate(){
           return date;
      }
      
      public void setDate(String date){
           this.date = date;
      }
      
      public String getTime(){
           return time;
      }
      
      public void setTime(String time){
           this.time = time;
      }
      
      public double getPriceWithTaxes(){
           return priceWithTaxes;
      }
      
      public void setPriceWithTaxes(double priceWithTaxes){
           this.priceWithTaxes = priceWithTaxes;
      }
      
      public Set<Recension> getRecensions(){
           return recensions;
      }
      
      public void setRecensions( Set<Recension> recensions){
           this.recensions = recensions;
      }
      
      public Set<TypeOfService> getTypes(){
           return types;
      }
      
      public void setTypes( Set<TypeOfService> types){
           this.types = types;
      }
      
      public CustomerService getService(){
           return service;
      }
      
      public void setService(CustomerService service){
           this.service = service;
      }
      

}
