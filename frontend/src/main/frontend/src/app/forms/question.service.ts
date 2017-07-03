import { Injectable }       from '@angular/core';

import { DropdownQuestion } from './question-dropdown';
import { QuestionBase }     from './question-base';
import { TextboxQuestion }  from './question-textbox';

@Injectable()
export class QuestionService {

  // Todo: get from a remote source of question metadata
  // Todo: make asynchronous
  getQuestionsDetails() {

    let questions: QuestionBase<any>[] = [

      new TextboxQuestion({
        key: 'username',
        label: 'Username',
        value: '',
        required: true,
        order: 1
      }),

      new TextboxQuestion({
        key: 'firstname',
        label: 'First name',
        value: '',
        required: true,
        order: 2
      }),

      new TextboxQuestion({
        key: 'lastname',
        label: 'Last name',
        value: '',
        required: true,
        order: 3
      }),

      new TextboxQuestion({
        key: 'email',
        label: 'email',
        value: '',
        required: true,
        order: 4
      }),

    ];

    return questions.sort((a, b) => a.order - b.order);
  }
}
