
import { NgModule, OnInit} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import {AppRoutingModule} from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { AuthenticationService, RegisterService } from './_services/index';
import { DetailsComponent } from './home/details.component';
import { HomeModule } from './home/home.module';
import { MyFormsModule } from './forms/myForms.module';
import { AgmCoreModule } from '@agm/core';

@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    MyFormsModule,
    HomeModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCVyB3bo0qI0x0snk9SXSKDa81jUYpH_oo'
    })
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
