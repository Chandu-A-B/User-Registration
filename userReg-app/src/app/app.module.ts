import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { HeaderComponent } from './components/header/header.component';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { AddUserAsAdminComponent } from './components/add-user-as-admin/add-user-as-admin.component';
import { ViewDetailsComponent } from './components/view-details/view-details.component';
import { UpdateUserAsAdminComponent } from './components/update-user-as-admin/update-user-as-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    AdminHomeComponent,
    UserHomeComponent,
    HeaderComponent,
    ViewDetailsComponent,
    UpdateUserComponent,
    AddUserComponent,
    AddUserAsAdminComponent,
    UpdateUserAsAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
