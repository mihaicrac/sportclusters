import { AuthenticationService } from '../_services';
import { ServerClientService, Method } from '../_services/serverclient.service';
import { Component, OnInit, Injectable } from '@angular/core';
import { Headers, RequestOptions, Http } from '@angular/http';

@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html',
  providers: [ServerClientService],
})

@Injectable()
export class HomeComponent implements OnInit {
  token: string;
  error: string;
  model: any = {};
  homeUrl = 'http://localhost:8080/api/home';



  constructor(private http: Http, private client: ServerClientService, private authentication: AuthenticationService) {
    this.token = this.authentication.getToken();
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
