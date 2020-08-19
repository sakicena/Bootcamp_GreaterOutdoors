import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { UserService } from "./user.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  title = "GreaterOutdoors";

  public userName: string;

  public password: string;

  public loginFlag: boolean = false;

  public customerflag: boolean = false;

  public custFlag: boolean = false;

  loginForm: FormGroup;

  submitted: boolean = false;

  constructor(
    public customerService: UserService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.router.navigate(["/login"]);
  }

  ngOnInit() {}
}
