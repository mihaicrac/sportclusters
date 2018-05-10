import { Component } from '@angular/core';
import { QuestionService } from '../forms/question.service'
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

import { AuthenticationService, TokenService } from '../rest-service/services';

@Component({
  templateUrl: 'details.component.html',
  moduleId: module.id,
  providers: [QuestionService]
})
export class DetailsComponent{
  questions: any[];
  error: string;
  model: any = {};
  homeUrl = '/api/users/';
  private headers:HttpHeaders =  new HttpHeaders({ 'Content-Type': 'application/json' });


  constructor(private http: HttpClient, private tokenService: TokenService, private qs: QuestionService) {
  }

  ngOnInit(): void {
    this.http.get(this.homeUrl + this.tokenService.getToken().id, {headers:this.headers})
    .subscribe(
      res => { this.model = res; this.questions = this.qs.getQuestionsDetails(); this.getFormValues(); } ,
      error => this.error = <any>error
    );
  }

  getFormValues(): void {
    let newquestions = [];
    for(var key in this.model) {
      for (let ctrl of this.questions) {
        if(key === ctrl.key){
          ctrl.value = this.model[key];
        }
      }
    }
  }


}
