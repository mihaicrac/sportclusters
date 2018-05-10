import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home.component';
import { DetailsComponent } from './details.component';
import { AccountComponent } from '../account-details/account.component';
import  {CreateEventComponent} from '../create-event/create-event.component';

const homeRoutes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: 'account-details',
        component: AccountComponent
      },
       {
        path: 'userList',
        component: DetailsComponent
      },
       {
        path: 'eventList',
        component: DetailsComponent
      },
      {
        path: 'searchEvent',
        component: DetailsComponent
      },
      {
        path: 'createEvent',
        component: CreateEventComponent
      },
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(homeRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class HomeRoutingModule { }