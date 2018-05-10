import { ModuleWithProviders, NgModule, Optional, SkipSelf }       from '@angular/core';  
import { CommonModule }      from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { RestServiceModule } from '../rest-service/rest-service.module';

import { AuthInterceptor } from '../rest-service/interceptor';

@NgModule({
  imports:      [ CommonModule ],
  declarations: [ ],
  exports:      [ BrowserModule, RestServiceModule, HttpClientModule ],
  providers:    [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true,
  }]
})
export class CoreModule {

  constructor (@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        'CoreModule is already loaded. Import it in the AppModule only');
    }
  }
}