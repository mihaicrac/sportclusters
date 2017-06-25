import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

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


  public getObservable<T>(typeH: Method, url: string, headers: string, payload?: string): Observable<T> {


    console.log('getObservable');

    if (typeH === Method.GET) {
      return this.http.get(url, headers).map((response: Response) => {
        console.log(response.json);
        return response.json();

      }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));
    } else {
      return this.http.post(url, headers).map((response: Response) => {
        console.log(response.json);
        return response.json();

      }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));

    }

  }


}
