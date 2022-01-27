import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user:User=new User();
  constructor(private userService:UserService,private router:Router) { }

  saveUser(){
    this.userService.createUser(this.user).subscribe(data=>{
      console.log(data);
      this.goToUserList();
    },
    error=>console.log(error));
  }
   
  //after saving record for going to list of record page
  goToUserList(){
    this.router.navigate(['/users']);
  }
  ngOnInit(): void {
  }
 onSubmit(){
  console.log(this.user); 
  this.saveUser();
 }
}
