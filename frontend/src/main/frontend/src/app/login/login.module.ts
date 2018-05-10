import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { MatInputModule, MatFormFieldModule,MatButtonModule,
  MatButtonToggleModule } from '@angular/material';




import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './';

@NgModule({
  imports: [
    SharedModule,
    LoginRoutingModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatButtonToggleModule
  ],
  declarations: [
    LoginComponent
  ]
})
export class LoginModule { }
