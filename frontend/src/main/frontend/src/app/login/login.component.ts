import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthenticationService } from '../rest-service/services';
import { LoginReq } from '../rest-service/services/authentication/model';
import { ApiError } from '../model';

@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css']
})
export class LoginComponent implements OnInit {

    loginForm: FormGroup;
    error: String;

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService,
        private fb: FormBuilder) { }

    ngOnInit() {
        this.authenticationService.logout();
        this.loginForm = this.fb.group({
            username:['', Validators.required],
            password:['', Validators.required]    
        });    
    }

    onSubmit(){
        if(this.loginForm.valid){
            this.login();
        }
    }

    login() {
        this.authenticationService.login(this.loginForm.value)
            .subscribe(result => {
                if (result === true) {
                    this.router.navigate(['home']);
                } else {
                    this.error = 'Username or password is incorrect';
                }
            }, error => {
                if((<ApiError>error).message){
                    this.error = error.message;
                }else{
                    this.error = error;
                }
            });
    }

    get username(){
        return this.loginForm.get('username');
    }

    get password(){
        return this.loginForm.get('password');
    }

}
