import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { EventType} from '../../model';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { EventPostReq } from './model';
import { Event } from '../../model';

@Injectable()
export class EventService {
  
  private _eventTypesUrl = '/api/events';
  private _headers:HttpHeaders =  new HttpHeaders({ 'Content-Type': 'application/json' });  

  constructor(private http: HttpClient) {
  }

  checkError(error:any):Observable<any>{
    return Observable.throw(error.error || 'Server error');
  }

  post(req:EventPostReq): Observable<Event>{
    return this.http.post<Event>(this._eventTypesUrl, req, {headers:this._headers})
    .catch((error:any) => this.checkError(error));
  }

  
}
