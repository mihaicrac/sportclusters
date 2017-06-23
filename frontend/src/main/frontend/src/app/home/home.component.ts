import { Component, OnInit, Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html'
})

@Injectable()
export class HomeComponent implements OnInit{
  model: any = {};


  constructor(private http: Http) {
  }
  ngOnInit(): void {
    // TODO Auto-generated method stub
    
    return;
  }
}
