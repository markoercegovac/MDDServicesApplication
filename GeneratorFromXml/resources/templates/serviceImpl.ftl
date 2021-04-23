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

@Service
@RequiredArgsConstructor
public class ${class.name}ServiceImpl implements ${class.name}Service {

	@Override
	public void save(${class.name}Dto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<${class.name}Dto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}