package ejb;

@EntityBlaBla
@Table(name = "BusinessApp")
public class BusinessApp {  
      private Element base_Element;

      public Element getBase_Element(){
           return base_Element;
      }
      
      public void setBase_Element(Element base_Element){
           this.base_Element = base_Element;
      }
      

}
