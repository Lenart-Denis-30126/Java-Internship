import { Component, OnInit } from '@angular/core';
import {UserService} from "../../Services/user.service";
import {Users} from "../../Entity/users";
import {Products} from "../../Entity/products";
import {ProductsService} from "../../Services/products.service";
import {Orders} from "../../Entity/orders";
import {OrdersService} from "../../Services/orders.service";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  users:Array<Users> = [];

  products:Array<Products> =[];

  orders:Array<Orders> =[];

  constructor(private userService: UserService, private productService:ProductsService, private orderService:OrdersService) { }

  getAllUsers(){

    this.userService.grabAllUsers().subscribe(users => {

      this.users=users;

    });

  }

  getAllProducts(){

    this.productService.grabAllProducts().subscribe(product => {

      this.products=product;

    });

  }

  getOrdersById(username: String) {

    this.orderService.grabOrderByUserUsername(username).subscribe(order=>
    {

      this.orders=order;

    })

  }

  getAllOrders(){

    this.orderService.grabAllOrders().subscribe(order => {

      this.orders=order;

    });

  }

  // getOrderWhereIdMatches(user:Users,order:Orders){
  //
  //
  //
  //
  // }

  ngOnInit(): void {
    this.getAllUsers();
    this.getAllOrders();
    this.getAllProducts();
  }

}
