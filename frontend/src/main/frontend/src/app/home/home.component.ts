import { AuthenticationService } from '../_services';
import { ServerClientService, Method } from '../_services/serverclient.service';
import { Component, OnInit, Injectable } from '@angular/core';
import { Headers, RequestOptions, Http } from '@angular/http';
import { QuestionService } from "../forms/question.service";

@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html',
  providers: [ServerClientService, QuestionService],
})

@Injectable()
export class HomeComponent implements OnInit {
  token: string;
  error: string;
  model: any = {};
  homeUrl = '/api/home';
  questions: any[];



  constructor(private http: Http, private client: ServerClientService, private authentication: AuthenticationService, private qs: QuestionService) {
    this.token = this.authentication.getToken();
    this.questions = qs.getQuestions();
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
