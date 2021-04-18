package ejb.model;

@EntityBlaBla
@Table(name = "Category")
public class Category {  
      private long id;
      private String name;
      private String description;
      private String servicePlace;
      private Set<CustomerService> services = new HashSet<CustomerService>();

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
      
      public String getDescription(){
           return description;
      }
      
      public void setDescription(String description){
           this.description = description;
      }
      
      public String getServicePlace(){
           return servicePlace;
      }
      
      public void setServicePlace(String servicePlace){
           this.servicePlace = servicePlace;
      }
      
      public Set<CustomerService> getServices(){
           return services;
      }
      
      public void setServices( Set<CustomerService> services){
           this.services = services;
      }
      

}
