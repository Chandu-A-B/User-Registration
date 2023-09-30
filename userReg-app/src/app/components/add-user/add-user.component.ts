import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user =new User()
  role=''
  toggle=true

  constructor(private regserv:ServiceService,private router:Router) { }

  ngOnInit(): void {
  }


  adduser(){

    console.log(localStorage.getItem("role"))
    if(localStorage.getItem("role") !== "admin"){
      
    this.user.role="user"
    

  }
    
    this.regserv.registerUserFromRemote(this.user).subscribe(
      data=>{
        this.router.navigate(['/user-home'])
      },error=>{console.log(error),
        this.router.navigate(['/user-home'])}
    )

  }
}
