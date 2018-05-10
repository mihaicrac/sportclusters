import { NgModule }       from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { AccountComponent } from './account.component';
import { AccountDetailsRoutingModule } from './account-details-routing.module';

@NgModule({
    imports: [
        SharedModule,
        AccountDetailsRoutingModule
    ],
    declarations: [
        AccountComponent
    ]
})
export class AccountDetailsModule {}