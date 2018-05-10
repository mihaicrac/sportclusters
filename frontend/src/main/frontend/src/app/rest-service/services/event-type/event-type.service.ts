import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { EventType} from '../../model';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class EventTypeService {
  
  private _eventTypesUrl = '/api/event-types';
  private _headers:HttpHeaders =  new HttpHeaders({ 'Content-Type': 'application/json' });  

  constructor(private http: HttpClient) {
  }

  checkError(error:any):Observable<any>{
    return Observable.throw(error.error || 'Server error');
  }

  getAll(): Observable<EventType[]>{
    return this.http.get<EventType[]>(this._eventTypesUrl, {headers:this._headers})
    .catch((error:any) => this.checkError(error));
  }

}
