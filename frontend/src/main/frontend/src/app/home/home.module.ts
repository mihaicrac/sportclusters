import { NgModule }       from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { MyFormsModule }  from '../forms/myForms.module';

import { CreateEventModule } from '../create-event/create-event.module';
import { DetailsComponent } from './details.component'
import { HomeComponent } from './home.component'
import { HomeRoutingModule} from './home-routing.module'
import { AgmCoreModule } from '@agm/core';
import { DialogResultExample, DialogResultExampleDialog } from './map.component'
import { MatDialogModule } from '@angular/material';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AccountDetailsModule } from '../account-details/account-details.module';

@NgModule({
  imports: [
    SharedModule,
    HomeRoutingModule,
    AccountDetailsModule,
    CreateEventModule,
    MyFormsModule,
    MatDialogModule,
    NoopAnimationsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCVyB3bo0qI0x0snk9SXSKDa81jUYpH_oo'
    }),
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