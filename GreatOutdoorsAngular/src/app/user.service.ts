import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

import { Observable } from "rxjs";
import { Login } from "./login";

@Injectable({
  providedIn: "root",
})
export class UserService {
  public userName: string;
  public password: string;

  constructor(private http: HttpClient) {}

  public loginValidate(userName: string, password: string) {
    this.password = password;
    this.userName = userName;
    return this.http.get(
      "http://localhost:1130/Login/Validate/" + userName + "/" + password
    );
  }
  public customerSignUp(user: Login) {
    return this.http.post("http://localhost:1130/SignUp/Register", user, {
      responseType: "text" as "json",
    });
  }


  public createProductMaster(user: Login) {
    return this.http.post("http://localhost:1130/Admin/CreateProductMaster", user, {
      responseType: "text" as "json",
    });
  }



}
