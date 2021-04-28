<head>
<meta charset="utf-8">
<title>${fmForm.title}</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
</head>
<br>
<body>
<div class="control-group">
	<form (ngSubmit)="submit()" >
		<div class="container">
			<h1>${fmForm.title}</h1>
			<div class="form-group">
			<#list fields as field>
				<#if field.label == "id">
					
				<#elseif field.type == "TEXT">
				<div>
					<br>
					<label>${field.label}</label>
					<input type="text" class="form-control" [(ngModel)]='model.${field.name}' name ='${field.name}'>
				</div>
				<#elseif field.type == "DATE">
				<div>
					<br>
					<label>${field.label}</label>
					<input type="date" class="form-control" [(ngModel)]='model.${field.name}' name ='${field.name}'>
				</div>
				<#elseif field.type == "SELECT">
				<div>
					<br>
					<label>${field.label}</label>
					<select class="form-control" [(ngModel)]='model.${field.name}' name ='${field.name}'>
					<#if class.name == "Category">
						<option>Salter</option>
						<option>Stolica</option>
						<option>Red</option>
						<option>Pult</option>
					<#elseif class.name == "Recension">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</#if>
					</select>
				</div>
				<#elseif field.type == "TEXTAREA">
				<div>
					<br>
					<label>${field.label}</label>
					<textarea [(ngModel)]='model.${field.name}' name ='${field.name}' class="form-control"></textarea>
				</div>
				<#elseif field.type == "TIME">
				<div>
					<br>
					<label>${field.label}</label>
					<input type="time" class="form-control" [(ngModel)]='model.${field.name}' name ='${field.name}'>
				</div>
				</#if>
					
			</#list>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>
<br>
<div class="container">
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<#list fields as field>
					<th scope="col">${field.label}</th>
				</#list>
				<th scope="col">Delete</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		<tbody>
			<tr *ngFor="let ${class.name?lower_case} of collection">
				<#list properties as property>
					<#if property.name == "id">
						<td>{{${class.name?lower_case}.${property.name}}}</td>
					<#elseif property.type == "String">
						<td>{{${class.name?lower_case}.${property.name}}}</td>
					<#elseif property.type == "double">
						<td>{{${class.name?lower_case}.${property.name}}}</td>
					</#if>
				</#list>
				<td><button class="btn btn-danger" value="Delete" (click)="delete(${class.name?lower_case})">Delete</button></td>
				<td><button class="btn btn-info" value="Edit" (click)="edit(${class.name?lower_case})">Edit</button></td>
			</tr>
		</tbody>
	</table>
</div>

	<br>
	<br>
	

