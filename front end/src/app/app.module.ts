import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import { AngularCourseComponent } from './angular-course/angular-course.component';
import { TesteComponent } from './teste/teste.component';

import { ClientsModule } from './clients/clients.module';

@NgModule({
  declarations: [ // colocar aqui tudo que criamos e pertence a esse modulo
    AppComponent,
    HelloComponent,
    AngularCourseComponent,
    TesteComponent
  ],
  imports: [ //outros modulos que queremos que faça parte desse modulo
    BrowserModule,
    AppRoutingModule,
    ClientsModule
  ],
  providers: [], // os services
  bootstrap: [AppComponent] // component que inicia a application
})
export class AppModule { }
