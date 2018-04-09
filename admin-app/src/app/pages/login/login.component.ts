import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
    selector: 'admin-login-page',
    templateUrl: './login.component.html',
    styles: [
        `
        .login-form {
            max-width: 300px;
          }
      
          .login-form-forgot {
            float: right;
          }
      
          .login-form-button {
            width: 100%;
          }
        `
    ]
})
export class LoginComponent implements OnInit {
    validateForm: FormGroup;


    login() {
        for (const i in this.validateForm.controls) {
            this.validateForm.controls[i].markAsDirty();
        }
       
        if(this.validateForm.valid){
            console.log(this.validateForm.value);
        }
    }

    constructor(private fb: FormBuilder) {
    }

    ngOnInit() {
        this.validateForm = this.fb.group({
            userName: [null, [Validators.required]],
            password: [null, [Validators.required]],
            remember: [true],
        });
    }
}