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
	model : ${class.name} = {
		<#list properties as property>
		<#if property.upper == 1>
		<#if property.joinType??>
		
		<#else> 
			<#if property.type = 'String'>
			${property.name} : "",
			<#else>
			${property.name} : 0,
			</#if>
		</#if>
		</#if>
		</#list>
	}
	collection : ${class.name}[] = [];
	isEdit : boolean = false;


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
				this.ngOnInit();
			},
			error => {
				//window.alert("Error");
			}
		);
	}
	
	delete(object:${class.name}) :void {
		if(window.confirm('Are sure you want to delete this item ?')){
			this.${class.name?lower_case}Service.delete(object.id).subscribe(
				data => {
					window.alert("Successfully Deleted");
					this.ngOnInit();
				},
				error => {
					//window.alert("Error");
				}
			);
		}
	}
	
	edit(object:${class.name}) :void {
		
		this.${class.name?lower_case}Service.edit(object.id).subscribe(
			data => {
					this.model=data;
				},
				error => {
					//window.alert("Error");
				}
			);
		
	}
 }