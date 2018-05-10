import { Injectable } from '@angular/core';
import { Token } from '../../model';
import * as jwtDecode from "jwt-decode";

@Injectable()
export class TokenService{

    private _tokenString:string;
    private _token:Token;

    constructor() {}

    getTokenString(): string {
        let token = undefined;
        if(this._tokenString){
          token = this._tokenString;
        }else{
          token = localStorage.getItem('currentUser');
          this._tokenString = token;
        }
        return token;
    }
    
    getToken(): Token {
        let token = undefined;
        if(this._token){
            token = this._token;
        }else{
            this._token = jwtDecode<Token>(this.getTokenString());
            token = this._token;
        }
        return this._token;
    }
    
    setToken(token: string): void {
        this._tokenString = token;
        localStorage.setItem('currentUser', token);    
        this._token = jwtDecode<Token>(token);
    }

    clearToken(): void{
        this._tokenString = undefined;
        localStorage.removeItem('currentUser');
        this._token = undefined;
    }
}
