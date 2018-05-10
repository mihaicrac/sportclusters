import {Injectable} from '@angular/core';
import {HttpEvent, HttpInterceptor, HttpHandler, HttpRequest} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import {AuthenticationService, TokenService} from '../services';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private tokenService: TokenService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.tokenService.getTokenString();
    if(token){
      const authReq = req.clone({headers: req.headers.append('Authorization', token)});
      return next.handle(authReq);
    }else{
      return next.handle(req);
    }
    
  }
}