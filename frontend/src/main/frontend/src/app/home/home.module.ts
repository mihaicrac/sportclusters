import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { MyFormsModule }  from '../forms/myForms.module';

import { DetailsComponent } from './details.component'
import { HomeComponent } from './home.component'
import { HomeRoutingModule} from './home-routing.module'
import { AgmCoreModule } from '@agm/core';
import { DialogResultExample, DialogResultExampleDialog } from './map.component'
import { MdDialogModule } from '@angular/material';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HomeRoutingModule,
    MyFormsModule,
    MdDialogModule,
    NoopAnimationsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCVyB3bo0qI0x0snk9SXSKDa81jUYpH_oo'
    })
  ],
  declarations: [
    DetailsComponent,
    HomeComponent,
    DialogResultExample,
    DialogResultExampleDialog
  ],
  entryComponents: [DialogResultExampleDialog]
})
export class HomeModule {}