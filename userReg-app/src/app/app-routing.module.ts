import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddUserAsAdminComponent } from './components/add-user-as-admin/add-user-as-admin.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UpdateUserAsAdminComponent } from './components/update-user-as-admin/update-user-as-admin.component';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { ViewDetailsComponent } from './components/view-details/view-details.component';

const routes: Routes = [
  {path:'',redirectTo:'/login', pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'register', component:RegisterComponent},
  {path:'admin-home', component:AdminHomeComponent},
  {path:'user-home', component:UserHomeComponent},
  {path:'view-details', component:ViewDetailsComponent},
  {path:'update-user', component:UpdateUserComponent},
  {path:'update-user-asAdmin', component:UpdateUserAsAdminComponent},
  {path:'add-user', component:AddUserComponent},
  {path:'add-user-asAdmin', component:AddUserAsAdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
