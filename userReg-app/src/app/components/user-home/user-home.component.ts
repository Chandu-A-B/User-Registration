import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  users! : User[];
  currUser! : string; 
  constructor(private userService:ServiceService, private router: Router) { }

  ngOnInit(): void {
    this.userService.getAllUsersFromRemote().subscribe(data =>{
      this.users = data;
      // this.datatooggle=true
      console.log(data)
    },
      error=>console.log(error));

      this.currUser=localStorage.getItem("loggedInUser") || ""

  }

 viewProfile(){
  this.router.navigate(['/view-details'])

}
  // (click)="router.navigate(['/master']);"

  logout(){
    //this.userService.dologout();
    localStorage.removeItem("id")
    localStorage.removeItem("role")
    sessionStorage.removeItem("role")
    localStorage.removeItem("id")
  }

  
}
