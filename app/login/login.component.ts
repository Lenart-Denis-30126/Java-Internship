import { Component, OnInit } from '@angular/core';
import {UserService} from "../../Services/user.service";
import {Users} from "../../Entity/users";
import {readBooleanType} from "@angular/compiler-cli/src/ngtsc/metadata/src/util";
import {Router} from "@angular/router";
import {LogInCredentialsDto} from "../../Entity/log-in-credentials-dto";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  redirect:boolean=false;


  constructor(private router:Router,private userService:UserService) { }

  ngOnInit(): void {
  }



  loginUser(){

    const usernameInput = <HTMLInputElement>document.getElementById("inputUserName");

    const username = usernameInput.value;


    const passwordInput = <HTMLInputElement>document.getElementById("inputPassword");

    const password = passwordInput.value;


    let userLog:LogInCredentialsDto=new LogInCredentialsDto(username,password);

    this.userService.login(userLog).subscribe(data=>{

      console.log(data);

    })

  }



}
