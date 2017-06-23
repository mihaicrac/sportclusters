import { User } from '../_models/user';
import { AuthenticationService } from './authentication.service';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';

@Injectable()
export class ServerClientService {

//  public getObservable(url: string, headers: string): Observable<User> {
//    return this.http.get(url, headers).map((response: Response) => {
// 
//      return response.json();
//      
//    }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));
//  }


  constructor(private http: Http, private authenticationService: AuthenticationService) {

  }




}
