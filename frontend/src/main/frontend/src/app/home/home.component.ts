import { Component, Injectable } from '@angular/core';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html',
  providers:[]
})

@Injectable()
export class HomeComponent{
  username:string = '';

  constructor(private authentication: AuthenticationService){
    this.username = JSON.parse(localStorage.getItem('currentUser'))["username"];
  }
}
