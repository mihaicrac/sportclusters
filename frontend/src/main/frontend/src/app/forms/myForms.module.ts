import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { DynamicFormComponent } from './dynamic-form.component';
import { DynamicFormQuestionComponent } from './dynamic-form-question.component';

@NgModule({
  imports: [BrowserModule, ReactiveFormsModule],
  declarations: [DynamicFormComponent, DynamicFormQuestionComponent],
  exports: [DynamicFormComponent, DynamicFormQuestionComponent]
})
export class MyFormsModule {
  constructor() {
  }
}
