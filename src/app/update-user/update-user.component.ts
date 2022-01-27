import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  id:number;
  user:User=new User();
  //cons having dependent obj
  constructor(private userService:UserService,
    private route:ActivatedRoute,
    private router:Router ) { }
    //to change the date type
    newDob:any;
    newDoj:any;
    //
  ngOnInit(): void {
    //gather id from ActivatedRoute
    this.id=this.route.snapshot.params['id'];
    this.userService.getUserById(this.id).subscribe(data=>{
      this.user=data;
      //setting date format 
     this. newDob = formatDate(this.user.dob,'yyyy-MM-dd',"en-US");
    this.newDoj = formatDate(this.user.doj,'yyyy-MM-dd',"en-US");
    },
    error=>console.log(error));
  }

  onSubmit(){
    //1st way
    //this.userService.updateUser(this.id,this.user).subscribe(err =>console.log(err));
     //2nd way
    this.userService.updateUser(this.id,this.user).subscribe(data=>{
      //after updating record to list of users page
      this.goToUserList();
     },
     error=>console.log(error));
  }
  //for users page details
  goToUserList(){
    this.router.navigate(['/users']);
  }
}
