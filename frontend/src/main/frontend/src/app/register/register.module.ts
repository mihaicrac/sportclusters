import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { RegisterRoutingModule } from './register-routing.module';
import { MatInputModule, MatFormFieldModule,MatButtonModule,
  MatButtonToggleModule } from '@angular/material';

import { RegisterComponent } from './';

@NgModule({
  imports: [
    SharedModule,
    CommonModule,
    RegisterRoutingModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule
  ],
  declarations: [
    RegisterComponent
  ]
})
export class RegisterModule { }
