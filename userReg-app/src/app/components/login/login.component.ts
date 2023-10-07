import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router,RouterModule } from '@angular/router';
import { ServiceService } from 'src/app/service/service.service';
import { User } from 'src/app/model/user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user=new User();
  // email:string;
  // password:string;
  msg='';
  emailid='';
  constructor(private regService:ServiceService, private router:Router){}
  
  ngOnInit(): void {
  }

  loginUser() {

    this.regService.loginUserFromRemote(this.user).subscribe(
      data => {
        localStorage.setItem("loggedInUser", this.user.userName);
        sessionStorage.setItem("loggedInUser", this.user.userName)

        console.log(localStorage.getItem("loggedInUser"))
        this.regService.getUserByIdFromRemote(this.user.userName).subscribe(
          data => {
            console.log(data.role);
            if (data.role == "admin") {
              localStorage.setItem("role", "admin")
              sessionStorage.setItem("role", "admin")
              this.router.navigate(['/admin-home']);
              console.log(localStorage.getItem("role") + "in role")
            } else {
              localStorage.setItem("role", "user")
              this.router.navigate(['/user-home'])
              console.log(localStorage.getItem("role") + "in role")
            }
          }, error => {console.log("error in get id role");}
        )
      },error=> {console.log(error);
        this.msg="Incorrect credentials !!";}
      )
    }
}
    
  //     if(localStorage.getItem("role") =="admin"){
        
  //     } else{
        
  //     }
  //   },
  //     error=> {console.log(error);
  //     this.msg="Incorrect credentials !!";
  // }
  //   )
  // }
  // getrole(id:string){
  //   this.regService.getUserByIdFromRemote(id).subscribe(
  //     data=>{
  //       console.log(data.role);
  //       if(data.role == "Admin"){
  //        localStorage.setItem("role","admin")
  //        sessionStorage.setItem("role","admin")
  //        console.log(localStorage.getItem("role") + "in role")
  //       } else {
  //         localStorage.setItem("role","user")
  //         console.log(localStorage.getItem("role") + "in role")
  //       }
  //     },error=>{
  //       console.log("error in get id role")
  //     }
  //   )
  // }



