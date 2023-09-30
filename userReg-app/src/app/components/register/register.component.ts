import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router,RouterModule } from '@angular/router';
import { ServiceService } from 'src/app/service/service.service';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user=new User();
  msg='';
  constructor(private regService:ServiceService, private router:Router){}
  
  ngOnInit(): void {
  }

  register(){
    this.user.role="user"
    this.regService.registerUserFromRemote(this.user).subscribe(
      data=>{
        console.log("response received");
        this.router.navigate(['/login']);

      },
      error=>{
        console.log(error);
        this.msg='User already registered !!';

      }
    )

  }
}
