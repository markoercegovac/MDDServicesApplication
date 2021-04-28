package generator.mbrs.controller;
import lombok.RequiredArgsConstructor;
import generator.mbrs.dto.*;
import generator.mbrs.service.${class.name}Service;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RequestMapping("/api/${class.name?lower_case}")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class ${class.name}Controller {
	
	private final ${class.name}Service ${class.name?lower_case}Service;
	
	@PostMapping
	public void save(@RequestBody ${class.name}Dto dto){
		${class.name?lower_case}Service.save(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<${class.name}Dto>> getAll(){
		return new ResponseEntity<>(${class.name?lower_case}Service.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id){
		${class.name?lower_case}Service.delete(id);
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<${class.name}Dto> edit(@PathVariable("id") Long id){
		return new ResponseEntity<>(${class.name?lower_case}Service.edit(id), HttpStatus.OK);
	}
}