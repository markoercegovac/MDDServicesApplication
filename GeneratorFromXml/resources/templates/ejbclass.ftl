package generator.mbrs.model;

import javax.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "${class.name}")
${class.visibility} class ${class.name} {  
<#list properties as property>
	<#if property.upper == 1 >
	<#if property.joinType??>
      @ManyToOne<#if property.fetchType??>(fetch = FetchType.${property.fetchType})</#if>
      @JoinColumn(name = "${property.name}", referencedColumnName = "id")	
	<#else>
	<#if property.name == 'id'>
      @Id
      @GeneratedValue(strategy = GenerationType.${property.strategy})
    <#else>
    </#if>
      @Column(name="${property.columnName}")
	</#if>
      ${property.visibility} ${property.type} ${property.name};
      
    <#elseif property.upper == -1 > 
      @JsonIgnore
      <#if property.cascadeType?? >
      @OneToMany(mappedBy = "${class.name?lower_case}", fetch = FetchType.${property.fetchType}, cascade = ${property.cascadeType})
      <#else>
      @OneToMany(mappedBy = "${class.name?lower_case}", fetch = FetchType.${property.fetchType})
      </#if>
      ${property.visibility} Set<${property.type}> ${property.name} = new HashSet<${property.type}>();
    
    <#else>  
    
    	<#list 1..property.upper as i>
      
      ${property.visibility} ${property.type} ${property.name}${i};
		</#list>  
    
    </#if>     
</#list>

<#list properties as property>
	<#if property.upper == 1 >   
      public ${property.type} get${property.name?cap_first}(){
           return ${property.name};
      }
      
      public void set${property.name?cap_first}(${property.type} ${property.name}){
           this.${property.name} = ${property.name};
      }
      
    <#elseif property.upper == -1 >
      public Set<${property.type}> get${property.name?cap_first}(){
           return ${property.name};
      }
      
      public void set${property.name?cap_first}( Set<${property.type}> ${property.name}){
           this.${property.name} = ${property.name};
      }
      
    <#else>   
    	<#list 1..property.upper as i>
      public ${property.type} get${property.name?cap_first}${i}(){
           return ${property.name}${i};
      }
      
      public void set${property.name?cap_first}${i}(${property.type} ${property.name}${i}){
           this.${property.name}${i} = ${property.name}${i};
      }
            
		</#list>  
    </#if>     
</#list>

}
