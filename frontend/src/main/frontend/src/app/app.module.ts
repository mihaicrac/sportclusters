
import { NgModule, OnInit} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import {AppRoutingModule} from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';


import { AuthenticationService, RegisterService } from './_services/index';



@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent
  ],
  providers: [ AuthenticationService, RegisterService],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
