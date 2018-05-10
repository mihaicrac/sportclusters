
import { NgModule, OnInit} from '@angular/core';
import { CoreModule } from './core/core.module';
import { AppRoutingModule } from './app-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { RegisterModule } from './register/register.module';
import { LoginModule } from './login/login.module';
import { HomeModule } from './home/home.module';

import { AppComponent } from './app.component';

@NgModule({
  imports:      [
    CoreModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    RegisterModule,
    LoginModule,
    HomeModule 
  ],
  declarations: [
    AppComponent
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
