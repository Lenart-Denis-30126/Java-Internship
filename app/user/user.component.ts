import { Component, OnInit } from '@angular/core';
import {UserService} from "../../Services/user.service";
import {Users} from "../../Entity/users";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users:Array<Users> = [];



  constructor(private userService: UserService ) { }

  getAllUsers(){

    this.userService.grabAllUsers().subscribe(users => {

      this.users=users;
      console.log(users);
    });

  }

  deleteUser(users:Users){

    this.userService.deleteUsers(users).subscribe((observer)=>{

      this.getAllUsers();

    })



  }

  updateUser(users:Users){
    this.userService.updateUsers(users).subscribe(()=>{
      console.log("User updated!")
    } )

  }

  ngOnInit(): void {
    this.getAllUsers();
  }

}
