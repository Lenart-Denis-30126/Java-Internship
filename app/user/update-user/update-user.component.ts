import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../Services/user.service";
import {Users} from "../../../Entity/users";
import {Orders} from "../../../Entity/orders";

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  users: Array<Users> = [];

  constructor(private userService: UserService) {
  }


  getAllUsers() {

    this.userService.grabAllUsers().subscribe(users => {

      this.users = users;

    });

  }

  fetchUser() {

    const usernameInput = <HTMLSelectElement>document.getElementById("selectId");

    const username = usernameInput.value;

    this.userService.grabByUsername(username).subscribe(user => {

        const nameInput = <HTMLInputElement>document.getElementById("nameId");

        nameInput.value = user.name;

        const emailInput = <HTMLInputElement>document.getElementById("emailId");

        emailInput.value = user.email;


        const carInput = <HTMLInputElement>document.getElementById("carId");

        carInput.value = user.car;

        const roleInput = <HTMLInputElement>document.getElementById("roleId");

        roleInput.value = user.role;

        const adressInput = <HTMLInputElement>document.getElementById("adressId");

        adressInput.value = user.adress;

      }
    )

  }

  updateUser(){

    const usernameInput=<HTMLInputElement>document.getElementById("selectId");

    const username=usernameInput.value;

    this.userService.grabByUsername(username).subscribe(user => {

        const nameInput = <HTMLInputElement>document.getElementById("nameId");

        user.name = nameInput.value;

        const emailInput = <HTMLInputElement>document.getElementById("emailId");

        user.email = emailInput.value;


        const carInput = <HTMLInputElement>document.getElementById("carId");

        user.car = carInput.value;

        const roleInput = <HTMLInputElement>document.getElementById("roleId");

        user.role = roleInput.value;

        const adressInput = <HTMLInputElement>document.getElementById("adressId");

        user.adress = adressInput.value;

      this.userService.updateUsers(user).subscribe();

      }


    )

  }

  ngOnInit(): void {

    this.getAllUsers();

  }

}
