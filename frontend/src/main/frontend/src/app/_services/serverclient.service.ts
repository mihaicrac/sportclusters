import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Options } from 'ts-node/dist';
import { AuthenticationService } from './authentication.service';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


export enum Method {
  POST,
  GET
};


@Injectable()
export class ServerClientService {
  options = {}

  constructor(private http: Http, private authentication: AuthenticationService) {
    const headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authentication.getToken()
    });
    this.options = new RequestOptions({ headers: headers });

  }


  public getObservable<T>(typeH: Method, url: string, options?: RequestOptions, payload?: string): Observable<T> {

    if(options){
      this.options = options;
    }

    let resp = new Observable<Response>();

    if (typeH === Method.GET) {
      resp = this.http.get(url, this.options);
    } else {
      resp = this.http.post(url, payload, this.options);
    }

    return resp.map((response: Response) => {
      return response.json();
    }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));

  }

}
