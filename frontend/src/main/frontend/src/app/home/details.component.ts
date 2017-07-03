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
    this.questions = qs.getQuestionsDetails();
  }

  ngOnInit(): void {

    const headers = new Headers({
      'Authorization': 'Bearer ' + this.token
    });

    const options = new RequestOptions({ headers: headers });


    this.client.getObservable(Method.GET, this.homeUrl, options).subscribe(
      res => this.model = res,
      error => this.error = <any>error);  

    return;

  }
}
