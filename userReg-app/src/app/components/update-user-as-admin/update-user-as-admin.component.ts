import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-update-user-as-admin',
  templateUrl: './update-user-as-admin.component.html',
  styleUrls: ['./update-user-as-admin.component.css']
})
export class UpdateUserAsAdminComponent implements OnInit {

  user =new User()

  tooglebutton=false

  constructor(private regsev:ServiceService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {


    this.regsev.getUserByIdFromRemote(localStorage.getItem("currUser") || "").subscribe(
      data=>this.user=data,
      error=>console.log(error)
    )
  }

  doupdate(){
    console.log(localStorage.getItem("currUser"))
    console.log(this.user.userName)
    console.log(this.user)
    
    this.regsev.updateUserFromRemote(this.user.userName || "",this.user).subscribe(
      data=>this.router.navigate(['/admin-home']),
      error=>console.log(error)
    )
  }

}