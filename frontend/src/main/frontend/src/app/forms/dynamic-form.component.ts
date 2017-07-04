import { Component, Input, OnInit, SimpleChange } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { QuestionBase } from './question-base';
import { QuestionControlService } from './question-control.service';

@Component({
  moduleId: module.id,
  selector: 'dynamic-form',
  templateUrl: 'dynamic-form.component.html',
  providers: [QuestionControlService]
})
export class DynamicFormComponent implements OnInit {

  @Input() questions: QuestionBase<any>[] = [];
  form: FormGroup;
  payLoad = '';

  constructor(private qcs: QuestionControlService) { }

  ngOnInit() {
    console.log("dyn-form");
    console.log(this.questions);
    this.form = this.qcs.toFormGroup(this.questions);
    console.log(this.form);
  }


  ngOnChanges(changes: SimpleChange) {
  for (let propName in changes) {
    let chng = changes[propName];
    let cur  = JSON.stringify(chng.currentValue);
    let prev = JSON.stringify(chng.previousValue);
    console.log(`${propName}: currentValue = ${cur}, previousValue = ${prev}`);
  }
}

  onSubmit() {
    this.payLoad = JSON.stringify(this.form.value);
  }
}
