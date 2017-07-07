import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Method, ServerClientService } from './serverclient.service';


@Injectable()
export class UpdateUserService {
    url = "/api/user"

    constructor(private client: ServerClientService) {}

    updateUser<T>(model:any): Observable<T>{
        return this.client.getObservable(Method.POST, this.url, model);      
    }

}    