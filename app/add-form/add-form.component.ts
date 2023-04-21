import { Component, OnInit } from '@angular/core';
import {UserService} from "../../Services/user.service";
import {Users} from "../../Entity/users";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit {

  redirect:boolean=false;

  constructor(private userService: UserService, private router:Router) { }


  redirectTo(){

    if(this.redirect == true ) {
      this.router.navigate(['users']);
    }
  }

  createUser(){



     const nameInput=<HTMLInputElement>document.getElementById("nameId");

     const name=nameInput.value;


    const usernameInput=<HTMLInputElement>document.getElementById("usernameId");

    const username=usernameInput.value;


    const emailInput=<HTMLInputElement>document.getElementById("emailId");

    const email=emailInput.value;


    const passwordInput=<HTMLInputElement>document.getElementById("passwordId");

    const password=passwordInput.value;


    const carInput=<HTMLInputElement>document.getElementById("carId");

    const car=carInput.value;

    const roleInput=<HTMLInputElement>document.getElementById("roleId");

    const role=roleInput.value;

    const adressInput=<HTMLInputElement>document.getElementById("adressId");

    const adress=adressInput.value;


    let user;
    if (name != null && username != null && email != null && password != null && car != null) {

      user = new Users(name, username, password, email, car, role, adress);

      this.userService.saveUser(user).subscribe((observer) => {

        this.redirect=true;
        this.redirectTo();

      });

    }

  }



  ngOnInit(): void {


  }

}
