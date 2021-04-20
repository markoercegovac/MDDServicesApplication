import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { FormsModule} from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';

<#list forms as form>
import { ${form.name}Component } from "./component/${form.componentName}/${form.name}.component";
</#list>

@NgModule({
  declarations: [
   	AppComponent,
   	NavigationComponent,
<#list forms as form>
	${form.name}Component,
</#list>
  ],
  
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule, //registrovanje servisa ne moramo explicitno da navedemo, ovo radi za nas
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


