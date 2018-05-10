import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import { TokenRes } from '../authentication';
import { TokenService } from '../token';
import { UserPostReq } from './model';

@Injectable()
export class UserService {
  
  private _usersUrl = '/api/users';
  private _headers:HttpHeaders =  new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private tokenService: TokenService) {
  }

  post(req: UserPostReq): Observable<boolean>{
    return this.http.post<TokenRes>(this._usersUrl, req, {headers:this._headers})
    .map((res:TokenRes) => this.checkPostSuccess(res))
      .catch((error:any) => this.checkError(error));
  }

  checkPostSuccess(response: TokenRes): boolean {
    const token = response.token;
    if (token) {
      this.tokenService.setToken(token);
      return true;
    } else {
      return false;
    }
  }
  checkError(error:any):Observable<any>{
    return Observable.throw(error.error || 'Server error');
  }


  existsEmail(email: String): Observable<boolean>{
    return this.http.get<Boolean>(this._usersUrl +"/email/"+ email, {headers:this._headers})
    .catch((error:any) => this.checkError(error));
  }


  existsUsername(username: String): Observable<boolean>{
    return this.http.get<Boolean>(this._usersUrl +"/username/"+ username, {headers:this._headers})
    .catch((error:any) => this.checkError(error));
  }

}
