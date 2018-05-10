import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import { TokenRes, LoginReq } from './model';
import { TokenService } from '../token';
import { ApiError } from '../../../model';


@Injectable()
export class AuthenticationService {
  
  private authUrl = '/api/tokens';
  private headers:HttpHeaders =  new HttpHeaders({ 'Content-Type': 'application/json' });


  constructor(private http: HttpClient, private tokenService: TokenService) {
  }

  login(req:LoginReq): Observable<boolean> {
    this.headers = this.headers.set("Authorization", btoa(JSON.stringify(req)));
    return this.http.get<TokenRes>(this.authUrl, {headers: this.headers})
      .map((res:TokenRes) => this.checkSuccess(res))
      .catch((error:any) => this.checkError(error));
  }

  logout(): void {
    this.tokenService.clearToken();
  }

  checkSuccess(response: TokenRes): boolean {
    const token = response.token;
    if (token) {
      this.tokenService.setToken(response.token);
      return true;
    } else {
      return false;
    }
  }

  checkError(error:any):Observable<any>{
    return Observable.throw(error.error || 'Server error');
  }

}
