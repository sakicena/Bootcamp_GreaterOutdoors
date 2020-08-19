import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./login/login.component";
import { SignupComponent } from "./signup/signup.component";
import { UserComponent } from "./user/user.component";
import { AdminComponent } from "./admin/admin.component";
import { CreateProductMasterComponent } from "./create-product-master/create-product-master.component";
import { GoAdminComponent } from "./go-admin/go-admin.component";
import { ProductmasterComponent } from "./productmaster/productmaster.component";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignupComponent },
  { path: "user", component: UserComponent },
  {
    path: "admin",
    component: AdminComponent,
    children: [
      { path: "", component: CreateProductMasterComponent },
      { path: "createProductMaster", component: CreateProductMasterComponent },
      { path: "**", redirectTo: "/admin", pathMatch: "full" },
    ],
  },
  { path: "goAdmin", component: GoAdminComponent },
  { path: "productMaster", component: ProductmasterComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
