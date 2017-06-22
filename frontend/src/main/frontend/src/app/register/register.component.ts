import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../_services/index';
import { FormGroup, FormBuilder, Validators, FormControl, AbstractControl, ValidatorFn } from '@angular/forms';

@Component({
  moduleId: module.id,
  templateUrl: 'register.component.html'
})

export class RegisterComponent implements OnInit {
  model: any = {};
  loading = false;
  error = '';
  registerForm: FormGroup;
  submitted = false;


  formErrors = {
    'username': '',
    'password': '',
    'firstname': '',
    'lastname': '',
    'email': '',
    'confpassword': ''
  };

  validationMessages = {
    'username': {
      'required': 'Name is required.',
      'minlength': 'Name must be at least 4 characters long.',
      'maxlength': 'Name cannot be more than 24 characters long.',
    },
    'password': {
      'required': 'Power is required.'
    },
    'firstname': {
      'required': 'Username is required.'
    },
    'lastname': {
      'required': 'Lastname is required.'
    },
    'email': {
      'required': 'Email is required.'
    },
    'confpassword': {
      'required': 'Confpassword is required.',
      'InvalidConfPass': 'ConfPassword must match password'
    }
  };


  constructor(private router: Router,
    private registerService: RegisterService,
    private fb: FormBuilder) { }

  register() {
    this.loading = true;
    this.registerService.register(this.model.username, this.model.password, this.model.firstname, this.model.lastname, this.model.email)
      .subscribe(result => {
        if (result === true) {
          // Register successful
          this.router.navigate(['home']);
        } else {
          // Register failed
          this.error = 'Error while registering';
          this.loading = false;
        }
      }, error => {
        this.loading = false;
        this.error = error;
      });
  }

  ngOnInit(): void {
    this.buildForm();
  }


  buildForm(): void {
    this.registerForm = this.fb.group({
      'username': ['', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(24),
        //  forbiddenNameValidator(/bob/i)
      ]
      ],
      'password': ['', Validators.required
      ],
      'firstname': ['', Validators.required
      ],
      'lastname': ['', Validators.required
      ],
      'email': ['', Validators.required
      ],
    });

    const confpassword = new FormControl('', [Validators.required, this.sameControlValueValidator(this.registerForm.controls['password'])]);
    this.registerForm.addControl('confpassword', confpassword);


    this.registerForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged(); // (re)set validation messages now
  }


  onValueChanged(data?: any) {
    if (!this.registerForm) { return; }
    const form = this.registerForm;


    for (const field in this.formErrors) {
      // clear previous error message (if any)
      this.formErrors[field] = '';
      const control = form.get(field);

      if (control && control.dirty && !control.valid) {
        const messages = this.validationMessages[field];
        for (const key in control.errors) {
          this.formErrors[field] += messages[key] + ' ';
        }
      }
    }
  }


  onSubmit() {
    this.submitted = true;
    if (this.registerForm.valid) {
      this.model = this.registerForm.value;
      this.register();
    }
  }

  sameControlValueValidator(otherControl: AbstractControl): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } => {
      const value = control.value;
      let no = true;
      if (otherControl.value === value) {
        no = false;
      }
      return no ? { 'InvalidConfPass': { value } } : null;
    };
  }


}



