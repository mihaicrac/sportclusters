import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';

import { DetailsComponent } from './details.component'
import { HomeComponent } from './home.component'
import { HomeRoutingModule} from './home-routing.module'

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HomeRoutingModule
  ],
  declarations: [
    DetailsComponent,
    HomeComponent
  ],
})
export class HomeModule {}