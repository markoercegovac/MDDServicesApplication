package generator.mbrs.service;

import generator.mbrs.dto.${class.name}Dto;
import generator.mbrs.model.${class.name};

import java.util.List;

public interface ${class.name}Service {
	void save(${class.name}Dto dto);
	void delete(Long id);
	List<${class.name}Dto> getAll();
}