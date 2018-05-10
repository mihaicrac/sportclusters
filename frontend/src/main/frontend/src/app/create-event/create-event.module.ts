import { NgModule }       from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { CreateEventComponent } from './create-event.component';
import { CreateEventRoutingModule } from './create-event-routing.module';

@NgModule({
    imports: [
        SharedModule,
        CreateEventRoutingModule
    ],
    declarations: [
        CreateEventComponent
    ]
})
export class CreateEventModule {}