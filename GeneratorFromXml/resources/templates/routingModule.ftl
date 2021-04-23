import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
<#list forms as form>
import { ${form.name}Component } from "./component/${form.componentName}/${form.name}.component";
</#list>

const routes: Routes = [
<#list forms as form>
{
	path:'${form.componentPath?keep_after("/")}',
	component:${form.name}Component
},
</#list>
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }