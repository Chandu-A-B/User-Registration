import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  user =new User()

  constructor(private regsev:ServiceService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    this.regsev.getUserByIdFromRemote(localStorage.getItem("loggedInUser") || "").subscribe(
      data=>this.user=data,
      error=>console.log(error)
    )
  }

  doupdate(){
    console.log(localStorage.getItem("loggedInUser"))
    console.log(this.user.userName)
    console.log(this.user)
    this.regsev.updateUserFromRemote(localStorage.getItem("loggedInUser") || "",this.user).subscribe(
      data=>this.router.navigate(['/view-details']),
      error=>console.log(error)
    )
  }

}