import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from './home.component';
import {DetailsComponent} from './details.component';

const homeRoutes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: 'details',
        component: DetailsComponent
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
        component: DetailsComponent
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