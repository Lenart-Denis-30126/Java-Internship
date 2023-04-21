import { Component, OnInit } from '@angular/core';
import {Orders} from "../../Entity/orders";
import {Users} from "../../Entity/users";
import {OrdersService} from "../../Services/orders.service";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

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
