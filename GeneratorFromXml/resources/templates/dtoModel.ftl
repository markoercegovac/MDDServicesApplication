package generator.mbrs.dto;
import lombok.Data;

import java.util.*;

@Data
${class.visibility} class ${class.name}Dto {  
<#list properties as property>
	<#if property.upper == 1 >
	<#if property.joinType??>
    <#else>
     ${property.visibility} ${property.type} ${property.name};
    </#if>
      
    <#else > 
    </#if>     
</#list>
}
