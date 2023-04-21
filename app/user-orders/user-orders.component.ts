import { Component, OnInit } from '@angular/core';
import {Orders} from "../../Entity/orders";
import {OrdersService} from "../../Services/orders.service";

@Component({
  selector: 'app-user-orders',
  templateUrl: './user-orders.component.html',
  styleUrls: ['./user-orders.component.css']
})


export class UserOrdersComponent implements OnInit {

  orders:Array<Orders> = [];


  constructor(private orderService: OrdersService ) { }

  getAllOrders(){

    this.orderService.grabAllOrders().subscribe(order => {

      this.orders=order;

    });

  }

  deleteOrders(order:Orders){

    this.orderService.removeOrder(order).subscribe((observer) =>{
      console.log("Users deleted!");
      this.getAllOrders();
    })

  }

  ngOnInit(): void {
    this.getAllOrders();
  }

}
