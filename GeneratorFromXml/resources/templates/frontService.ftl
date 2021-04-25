import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { ${class.name} } from "../model/${class.name}.model";

@Injectable({
  providedIn: 'root'
})

export class ${class.name}Service {

	private URL: string;

	constructor(private http: HttpClient) {
	    //url koji prihvata sertifikate iz spring aplikacije
	    this.URL='http://localhost:9090/api/${class.name?lower_case}';
	}

	public getAll(): Observable<${class.name}[]>{
		return this.http.get<${class.name}[]>(this.URL);
	}
	
	public save(${class.name?lower_case}:${class.name}){
		return this.http.post(this.URL,${class.name?lower_case});
	}
	
	public delete(id : number){
		return this.http.delete(this.URL + '/' + id);
	}
}