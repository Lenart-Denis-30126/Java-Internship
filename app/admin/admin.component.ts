import { Component, OnInit } from '@angular/core';
import {Users} from "../../Entity/users";
import {UserService} from "../../Services/user.service";
import {OrdersService} from "../../Services/orders.service";
import {ProductsService} from "../../Services/products.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  numberOfUsers:number=0;

  numberOfOrders:number=0;

  numberOfProducts:number=0;



  constructor(private userService:UserService, private orderService:OrdersService, private productsService:ProductsService) { }




  ngOnInit(): void {



  this.userService.grabAllUsers().subscribe(users=>{

    this.numberOfUsers=users.length;

    }


  )

    this.orderService.grabAllOrders().subscribe(orders=>{

      this.numberOfOrders=orders.length;

    })

    this.productsService.grabAllProducts().subscribe(products=>{

      this.numberOfProducts=products.length;

    })


  }

}
