import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DynamicFormComponent } from './forms/dynamic-form.component';
import { DynamicFormQuestionComponent } from './forms/dynamic-form-question.component';

@NgModule({
  imports: [BrowserModule, ReactiveFormsModule],
  declarations: [AppComponent, DynamicFormComponent, DynamicFormQuestionComponent],
})
export class MyFormsModule {
  constructor() {
  }
}
