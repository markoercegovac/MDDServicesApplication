package ejb.model;

@EntityBlaBla
@Table(name = "Recension")
public class Recension {  
      private long id;
      private String comment;
      private Integer grade;
      private Appointment apointment;

      public long getId(){
           return id;
      }
      
      public void setId(long id){
           this.id = id;
      }
      
      public String getComment(){
           return comment;
      }
      
      public void setComment(String comment){
           this.comment = comment;
      }
      
      public Integer getGrade(){
           return grade;
      }
      
      public void setGrade(Integer grade){
           this.grade = grade;
      }
      
      public Appointment getApointment(){
           return apointment;
      }
      
      public void setApointment(Appointment apointment){
           this.apointment = apointment;
      }
      

}
