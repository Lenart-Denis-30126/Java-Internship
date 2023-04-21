import { Component, OnInit } from '@angular/core';
import {Orders} from "../../Entity/orders";
import {OrdersService} from "../../Services/orders.service";

@Component({
  selector: 'app-see-order',
  templateUrl: './see-order.component.html',
  styleUrls: ['./see-order.component.css']
})
export class SeeOrderComponent implements OnInit {

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
