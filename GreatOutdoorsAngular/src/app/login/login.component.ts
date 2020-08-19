import { Component, OnInit } from "@angular/core";
import { Validators, FormBuilder, FormGroup } from "@angular/forms";
import { UserService } from "../user.service";
import { Router } from "@angular/router";
import { Login } from "../login";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  public loginarr: Login[] = [];
  public userName: string;
  public password: string;
  public loginFlag: boolean = false;
  public adminFlag: boolean = false;
  public empFlag: boolean = false;
  loginArr: Login[] = [];

  loginForm: FormGroup;
  invalidLogin = false;

  submitted: boolean = false;
  message: any;
  errorFlag: boolean;
  constructor(
    public userservice: UserService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}
  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userName: ["", Validators.required],
      password: ["", Validators.required],
    });
  }


   // convenience getter for easy access to form fields
  get formFields() {
    return this.loginForm.controls;
  }

  public authenticate() {
    this.submitted = true;
    if (this.loginForm.valid) {
      this.userName = this.loginForm.controls.userName.value;
      this.password = this.loginForm.controls.password.value;
      this.userservice.loginValidate(this.userName, this.password).subscribe(
        (data) => {
          if (data === 1) {
            this.router.navigate(["/admin"]);
          } else if (data === 2) {
            this.router.navigate(["/goAdmin"]);
          } else if (data == 3) {
            this.router.navigate(["/user"]);
          } else if (data == 4) {
            this.router.navigate(["/productMaster"]);
          }
        },
        (error) => {
          this.message = error.error;
          this.errorFlag = true;
        }
      );
    } else {
      return;
    }
  }
}
