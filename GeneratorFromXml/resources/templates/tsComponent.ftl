import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ${class.name} } from 'src/app/model/${class.name}.model';
import { ${class.name}Service } from 'src/app/service/${class.name}.service';
@Component({
  	selector: '${fmForm.componentName}',
  	templateUrl: './${class.name}.component.html',
  	styleUrls: ['./${class.name}.component.css']
})

export class ${class.name}Component implements OnInit {
	model! : ${class.name}
	collection : ${class.name}[] = [];


	constructor(private ${class.name?lower_case}Service:${class.name}Service){}
	
	ngOnInit(): void {
		this.${class.name?lower_case}Service.getAll().subscribe(
			data => {
				this.collection = data;
			},
			error => {
	       		//window.alert("Error");
	      	}
	   	);
	}
	
	submit(): void {
		this.${class.name?lower_case}Service.save(this.model).subscribe(
			data => {
				window.alert("Successfully Added");
			},
			error => {
				//window.alert("Error");
			}
		);
	}
	
	delete(object:${class.name}) :void {
		this.${class.name?lower_case}Service.delete(object.id).subscribe(
			data => {
				window.alert("Successfully Deleted");
			},
			error => {
				//window.alert("Error");
			}
		);
	}
 }