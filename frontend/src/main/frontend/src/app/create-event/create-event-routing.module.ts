import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEventComponent } from './create-event.component';

const eventRoutes: Routes = [
  {
    path: 'account-details',
    component: CreateEventComponent,
  }]

@NgModule({
  imports: [RouterModule.forChild(eventRoutes)],
  exports: [RouterModule]
})
export class CreateEventRoutingModule { }
