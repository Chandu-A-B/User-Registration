import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  users! : User[];
  currUser! : string;
  // datatooggle=false

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

  logout(){
    //this.userService.dologout();
    localStorage.removeItem("id")
    localStorage.removeItem("role")
    sessionStorage.removeItem("role")
    localStorage.removeItem("id")
  }


  deleteByIdUser(userName:string){
     this.userService.deleteUserFromRemote(userName).subscribe(
      data=>{
        this.ngOnInit(),
        console.log('data deleted')
        
      },
      error=>{
        console.log(error);
        
      }
    )
  }

  processUpdate(userName:string){
    this.userService.saveCurrUsername(userName)
    this.router.navigate(["/update-user-asAdmin"])
    
  }
      
     

}
