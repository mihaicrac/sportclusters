import { Component, Injectable, ChangeDetectorRef } from '@angular/core';
import {MediaMatcher} from '@angular/cdk/layout';

import { AuthenticationService, TokenService } from '../rest-service/services';

@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html',
  styleUrls: ['home.component.css'],
  providers:[]
})

@Injectable()
export class HomeComponent{
  username:string = '';
  mobileQuery: MediaQueryList;
  
  private _mobileQueryListener: () => void;

  constructor(private tokenService: TokenService,
              changeDetectorRef: ChangeDetectorRef, media: MediaMatcher){
    
    this.username = tokenService.getToken().sub;
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }

}
