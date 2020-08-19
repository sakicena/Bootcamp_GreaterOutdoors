import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { UserService } from "../user.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  addUserForm: FormGroup;
  submitted: boolean = false;
  message: string;
  errorFlag = false;

  constructor(    private userService: UserService,
    private formBuilder: FormBuilder,
    private router: Router) { }

    ngOnInit() {
      this.addUserForm = this.formBuilder.group({
        
        userName: ["", [Validators.required, Validators.pattern("[A-Za-z][A-Za-z0-9]{7,20}")]],
        password: ["",[ Validators.required,Validators.pattern("[A-Za-z0-9!@#]{8,20}")]],
        phoneNumber: ["", [Validators.required, Validators.pattern("[6-9][0-9]{9}")]],
        email:["",[Validators.required,Validators.pattern("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$")]],

      });
      if (localStorage.usr != null) {
        localStorage.removeItem("usr");
      }
    }

       // convenience getter for easy access to form fields
  get formFields() {
    return this.addUserForm.controls;
  }


    addUser() {
      this.submitted = true;
      if (this.addUserForm.invalid) {
        return alert(`Not Registered`);
      }
      console.log(this.addUserForm.value);
      this.userService.customerSignUp(this.addUserForm.value).subscribe(
        (data) => {
          alert(
            `Hello, ${this.addUserForm.controls.userName.value}. Your User has been created successfully😊`
          );
           this.router.navigate(["login"]);
        },
        (error) => {
          alert(error.error);
          this.message = error.error;
          this.errorFlag = true;
        }
      );
    }

}
