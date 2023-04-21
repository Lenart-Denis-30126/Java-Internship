import { Component, OnInit } from '@angular/core';
import {Users} from "../../../Entity/users";
import {Orders} from "../../../Entity/orders";
import {UserService} from "../../../Services/user.service";
import {OrdersService} from "../../../Services/orders.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-updateorder',
  templateUrl: './updateorder.component.html',
  styleUrls: ['./updateorder.component.css']
})
export class UpdateorderComponent implements OnInit {


  orders: Array<Orders> = [];

  redirect:boolean=false;

  constructor(private router:Router,private orderService: OrdersService) { }


  getAllOrders() {

    this.orderService.grabAllOrders().subscribe(order => {

      this.orders = order;

    });

  }
  fetchOrder() {

    const orderIdInput = <HTMLSelectElement>document.getElementById("selectId");

    let orderId: number = +orderIdInput.value;

    this.orderService.grabOrderById(orderId).subscribe(order => {

        const priceInput = <HTMLInputElement>document.getElementById("priceId");

        priceInput.value = String(order.id) ;

        const detailsInput = <HTMLInputElement>document.getElementById("detailsId");

      detailsInput.value = String(order.details);

      const refInput = <HTMLInputElement>document.getElementById("refId");

      refInput.value = String(order.userId);


      }
    )

  }

  redirectTo(){

    if(this.redirect == true ) {
      this.router.navigate(['orders']);
    }
  }

  updateOrder(){


    const orderIdInput=<HTMLInputElement>document.getElementById("selectId");

    let orderId: number = +orderIdInput.value;

    this.orderService.grabOrderById(orderId).subscribe(order => {

    console.log(order);

        const priceInput = <HTMLInputElement>document.getElementById("priceId");

       order.priceTotal=priceInput.valueAsNumber;


      const detailsInput = <HTMLInputElement>document.getElementById("detailsId");

      order.details=detailsInput.value;

      console.log(orderId,priceInput,detailsInput,order);
      this.orderService.updateOrders(order).subscribe((observer)=>{

        this.redirect=true;
        this.redirectTo();

      });


      }


    )

  }


  ngOnInit(): void {

    this.getAllOrders();
  }

}
