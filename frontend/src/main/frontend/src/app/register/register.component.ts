import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService} from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'register.component.html'
})

export class RegisterComponent {
    model: any = {};
    loading = false;
    error = '';

    constructor(private router: Router,
                private registerService: RegisterService) { }

    register() {
      this.loading = true;
      this.registerService.register(this.model.username, this.model.password, this.model.firstname, this.model.lastname)
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
}
