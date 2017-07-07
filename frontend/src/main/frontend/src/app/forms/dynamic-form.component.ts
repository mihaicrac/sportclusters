import { Component, Input, OnInit, SimpleChange } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { QuestionBase } from './question-base';
import { QuestionControlService } from './question-control.service';
import { UpdateUserService} from '../_services/updateUser.service'

@Component({
  moduleId: module.id,
  selector: 'dynamic-form',
  templateUrl: 'dynamic-form.component.html',
  providers: [QuestionControlService, UpdateUserService]
})
export class DynamicFormComponent implements OnInit {

  @Input() questions: QuestionBase<any>[] = [];
  form: FormGroup;
  payLoad = '';
  model;
  error:string;

  constructor(private qcs: QuestionControlService, private updateUser: UpdateUserService) { }

  ngOnInit() {
    this.form = this.qcs.toFormGroup(this.questions);
  }

  onSubmit() {
    this.payLoad = JSON.stringify(this.form.value);
  
    if(this.form.valid){
      this.updateUser.updateUser(this.payLoad).subscribe(
      res =>  this.model = res,
      error => this.error = <any>error);  

    }
  }

  
}
