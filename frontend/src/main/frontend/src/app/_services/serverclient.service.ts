import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


export enum Method {
  POST,
  GET
};


@Injectable()
export class ServerClientService {

  constructor(private http: Http) { }


  public getObservable<T>(typeH: Method, url: string, options: RequestOptions, payload?: string): Observable<T> {

    let resp = new Observable<Response>();

    if (typeH === Method.GET) {
      resp = this.http.get(url, options);
    } else {
      resp = this.http.post(url, payload, options);
    }

    return resp.map((response: Response) => {
      return response.json();
    }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));

  }

}
