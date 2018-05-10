import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators, FormControl, AbstractControl, ValidatorFn } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/delay';
import 'rxjs/add/observable/of';

import { UserService, UserPostReq } from '../rest-service/services/user';
import { VALID } from '@angular/forms/src/model';

@Component({
  moduleId: module.id,
  templateUrl: 'register.component.html',
  styleUrls: ['register.component.css']
})

export class RegisterComponent implements OnInit {
  
  registerForm: FormGroup;
  error:string;

  constructor(private router: Router,
    private userService: UserService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.buildForm();
  }
  
  buildForm(): void {
    this.registerForm = this.fb.group({
      'username': ['', [
                        Validators.required,
                        Validators.maxLength(40)
                      ],
                        this.sameUsernameInDB().bind(this)
                      ,
                    
      ],
      'firstname': ['', [
                          Validators.maxLength(40)
                        ] 
      ],
      'lastname': ['',[
                        Validators.maxLength(40)
                      ]   
      ],
      'email': ['', [
                      Validators.required,
                      Validators.maxLength(254),
                    ],
                    this.sameEmailInDB().bind(this),
      ]
    });

    const confpassword = new FormControl('');
    this.registerForm.addControl('confpassword', confpassword);
    const password = new FormControl('');
    this.registerForm.addControl('password', password);
    confpassword.setValidators([Validators.required, this.sameControlValueValidator(this.registerForm.controls['password'], "invalidConfPass")]);
    password.setValidators([Validators.required]);
    password.valueChanges.subscribe(result => {
      confpassword.updateValueAndValidity();
    });
    
  }


  register() {
    this.userService.post(this.registerForm.value)
      .subscribe(result => {
        if (result === true) {
          this.router.navigate(['home']);
        } else {
          this.error = 'Error while registering';
        }
      }, error => {
        this.error = error.message;
      });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      this.register();
    }
  }

  isInValid(){
    return (this.registerForm.pending || this.registerForm.invalid); 
  }

  sameControlValueValidator(otherControl: AbstractControl, key:string): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } => {
      const value = control.value;
      let same = false;
      if (otherControl.value === value) {
        same = true;
      }
      return same ? null : JSON.parse('{ "'+key+'" :  true }');
    };
  }

  //TO DO refactor
  sameUsernameInDB(): ValidatorFn {
    return (control: AbstractControl): Observable<{ [key: string]: any }> => {
      const value = control.value;
      if(value){
        return this.userService.existsUsername(value).map((value:boolean) => {
          return value ? { 'sameUsername': true } : null;
        });
      }else{
        return Observable.of({ 'sameUsername': true });
      }  
       
    };
  }

  //TO DO refactor 
  sameEmailInDB(): ValidatorFn {
    return (control: AbstractControl): Observable<{ [key: string]: any }> => {
      const value = control.value;
      if(value){
        return this.userService.existsEmail(value).map((value:boolean) => {
          return value ? { 'sameEmail': true } : null;
        })
      }else{
        return Observable.of({ 'sameEmail': true });
      }  
       
    };
  }

  getMsgs(control:string):string[]{
    return Object.keys(this.validationMessages[control]);
  }

  validationMessages = {
    'username': {
      'required': 'username is required',
      'maxlength': 'username max length is 40 characters long',
      'sameUsername': 'same username is already registered'
    },
    'password': {
      'required': 'password is required',
      'invalidPass': 'password must match confpassword'
    },
    'firstname': {
      'maxlength': 'firstname cannot be more than 40 characters long'
    },
    'lastname': {
      'maxlength': 'lastname cannot be more than 40 characters long'
    },
    'email': {
      'required': 'email is required',
      'maxlength':'email max length is 254 characters long',
      'sameEmail': 'same email is already registered',
    },
    'confpassword': {
      'required': 'confpassword is required',
      'invalidConfPass': 'confpassword must match password'
    }
  };


  get username(){
    return this.registerForm.get('username');
  }

  get password(){
    return this.registerForm.get('password');
  }

  get firstname(){
    return this.registerForm.get('firstname');
  }

  get lastname(){
    return this.registerForm.get('lastname');
  }

  get email(){
    return this.registerForm.get('email');
  }

  get confpassword(){
    return this.registerForm.get('confpassword');
  }

}



