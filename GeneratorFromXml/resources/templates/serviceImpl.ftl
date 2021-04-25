package generator.mbrs.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import generator.mbrs.dto.*;
import generator.mbrs.model.*;
import generator.mbrs.repository.*;
import generator.mbrs.service.${class.name}Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class ${class.name}ServiceImpl implements ${class.name}Service {

	private final ${class.name}Repository ${class.name?lower_case}Repository;

	@Override
	public void save(${class.name}Dto dto) {
		${class.name} entity = new ${class.name}();
		<#list properties as property>
		<#if property.upper == 1>
		<#if property.joinType??>
			entity.set${property.name?cap_first}(null);
		<#else>
			entity.set${property.name?cap_first}(dto.get${property.name?cap_first}());
		</#if>
		<#elseif property.upper ==-1>
			entity.set${property.name?cap_first}(new HashSet<>());
		</#if>
		</#list>
		
		${class.name?lower_case}Repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		${class.name} a = ${class.name?lower_case}Repository.getOne(id);
		${class.name?lower_case}Repository.delete(a);
	}

	@Override
	public List<${class.name}Dto> getAll() {
		List<${class.name}Dto> dtoList = new ArrayList<>();
		List<${class.name}> all = ${class.name?lower_case}Repository.findAll();
		for(${class.name} e : all){
			${class.name}Dto dto = mapTo(e);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	private ${class.name}Dto mapTo(${class.name} entity){
		${class.name}Dto dto = new ${class.name}Dto();
		<#list properties as property>
		<#if property.upper == 1>
		<#if property.joinType??>
		<#else>
		dto.set${property.name?cap_first}(entity.get${property.name?cap_first}());
		</#if>
		</#if>
		</#list>
		return dto;
	}
}