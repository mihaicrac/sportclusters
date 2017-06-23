import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class RegisterService {
    private registerUrl = '/api/doregister';
    private headers = new Headers({'Content-Type': 'application/json'});

    constructor(private http: Http) {
    }

    register(username: string, password: string, firstname: string, lastname: string, email: string): Observable<boolean> {
        return this.http.post(this.registerUrl, JSON.stringify({username: username, password: password, firstname: firstname, lastname: lastname, email: email}), {headers: this.headers})
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let token = response.json() && response.json().token;
                if (token) {
                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify({ username: username, token: token }));

                    // return true to indicate successful login
                    return true;
                } else {
                    // return false to indicate failed login
                    return false;
                }
            }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

}
