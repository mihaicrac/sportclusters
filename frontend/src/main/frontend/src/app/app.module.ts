
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
import { DetailsComponent } from './home/details.component';
import { HomeModule } from './home/home.module';
import { MyFormsModule } from './forms/myForms.module';

@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    MyFormsModule,
    HomeModule
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent
  ],
  providers: [ AuthenticationService, RegisterService],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
