
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import {AppRoutingModule} from "./app-routing.module";

import { AppComponent }  from './app.component';
import { HomeComponent } from './home.component';
import { LoginComponent } from './login/index';

import { AuthenticationService } from './_services/index';


@NgModule({
  imports:      [
    BrowserModule,
      FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    HomeComponent
  ],
  providers: [ AuthenticationService ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
