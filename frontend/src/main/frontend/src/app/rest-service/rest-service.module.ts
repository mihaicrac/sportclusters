import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {AuthenticationService, TokenService, UserService, EventTypeService, EventService} from './services'

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers:[ AuthenticationService, TokenService, UserService, EventTypeService, EventService ]
})
export class RestServiceModule { }
