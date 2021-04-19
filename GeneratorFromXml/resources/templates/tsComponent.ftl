import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ${class.name} } from '../model/${class.name}';
import { ${class.name}Service} from '../service/${class.name}.service'
@Component({
  	selector: '${fmForm.componentName}',
  	templateUrl: './${fmForm.componentName}.component.html',
  	styleUrls: ['./${fmForm.componentName}.component.css']
})

export class ${class.name}Component implements OnInit {
	model : ${class.name}
	collection : ${class.name}[]


	constructor(private ${class.name?lower_case}Service:${class.name}Service){}
	
	ngOnInit(): void {
		this.${class.name?lower_case}Service.getAll().subscribe(
			data => {
				this.collection = data;
			},
			error => {
	       		windows.alert("Error");
	      	}
	   	);
	}
	
	submit(): void {
		this.${class.name?lower_case}Service.save(this.model).subscribe(
			data => {
				window.alert("Successfully Added");
			},
			error => {
				windows.alert("Error");
			}
		);
	}
	
	delete(object:${class.name}) :void {
		this.${class.name?lower_case}Service.delete(object.id).subscribe(
			data => {
				window.alert("Successfully Deleted");
			},
			error => {
				windows.alert("Error");
			}
		);
	}
 }