import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { UserService } from "./user.service";
import { AdminComponent } from "./admin/admin.component";
import { UserComponent } from "./user/user.component";
import { LoginComponent } from "./login/login.component";
import { CreateProductMasterComponent } from "./create-product-master/create-product-master.component";
import { GoAdminComponent } from "./go-admin/go-admin.component";
import { SignupComponent } from "./signup/signup.component";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ProductmasterComponent } from './productmaster/productmaster.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    UserComponent,
    LoginComponent,
    CreateProductMasterComponent,
    GoAdminComponent,
    SignupComponent,
    ProductmasterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [UserService],
  bootstrap: [AppComponent],
})
export class AppModule {}
