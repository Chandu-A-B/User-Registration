import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-view-details',
  templateUrl: './view-details.component.html',
  styleUrls: ['./view-details.component.css']
})
export class ViewDetailsComponent implements OnInit {
users:User = new User();
nnn=localStorage.getItem('loggedInUser')
  constructor(private userService:ServiceService, private router: Router) { }

  ngOnInit(): void {
    //this.nnn=localStorage.getItem('loggedInUser')
    console.log(localStorage.getItem('loggedInUser') + "in")
    this.userService.getUserByIdFromRemote(this.nnn||"chandu").subscribe(
      data =>{
      this.users = data;
      // this.datatooggle=true
      console.log(data)
    },
      error=>console.log(error));

  }

}

