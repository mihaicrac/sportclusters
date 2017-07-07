import { Component } from '@angular/core';
import { QuestionService } from '../forms/question.service'
import { Headers, RequestOptions, Http } from '@angular/http';
import { ServerClientService, Method } from '../_services/serverclient.service';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  templateUrl: 'details.component.html',
  moduleId: module.id,
  providers: [ServerClientService, QuestionService]
})
export class DetailsComponent{
  questions: any[];
  token: string;
  error: string;
  model: any = {};
  homeUrl = '/api/userDetails';

  constructor(private http: Http, private client: ServerClientService, private authentication: AuthenticationService, private qs: QuestionService) {
    this.token = this.authentication.getToken();
  }

  ngOnInit(): void {
    this.client.getObservable(Method.GET, this.homeUrl).subscribe(
      res => { this.model = res; this.questions = this.qs.getQuestionsDetails(); this.getFormValues(); } ,
      error => this.error = <any>error);
    return;

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
