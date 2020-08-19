import { Component, OnInit } from "@angular/core";

import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { UserService } from "../user.service";

@Component({
  selector: "app-create-product-master",
  templateUrl: "./create-product-master.component.html",
  styleUrls: ["./create-product-master.component.css"],
})
export class CreateProductMasterComponent implements OnInit {
  addProductMasterForm: FormGroup;
  submitted: boolean = false;
  message: string;
  errorFlag = false;

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {}

  ngOnInit() {
    this.addProductMasterForm = this.formBuilder.group({
      userName: [
        "",
        [Validators.required, Validators.pattern("[A-Za-z][A-Za-z0-9]{7,20}")],
      ],
      password: [
        "",
        [Validators.required, Validators.pattern("[A-Za-z0-9!@#]{8,20}")],
      ],
      phoneNumber: [
        "",
        [Validators.required, Validators.pattern("[6-9][0-9]{9}")],
      ],
      email: ["", [Validators.required,Validators.pattern("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$")]],
    });
    if (localStorage.usr != null) {
      localStorage.removeItem("usr");
    }
  }
       // convenience getter for easy access to form fields
       get formFields() {
        return this.addProductMasterForm.controls;
      }



  addUser() {
    this.submitted = true;
    if (this.addProductMasterForm.invalid) {
      return alert(`Not Registered`);
    }
    console.log(this.addProductMasterForm.value);
    this.userService
      .createProductMaster(this.addProductMasterForm.value)
      .subscribe(
        (data) => {
          alert(
            `Hello, ${this.addProductMasterForm.controls.userName.value}. Product Master has been created successfully😊`
          );
          this.router.navigate(["admin"]);
        },
        (error) => {
          alert(error.error);
          this.message = error.error;
          this.errorFlag = true;
        }
      );
  }
}
