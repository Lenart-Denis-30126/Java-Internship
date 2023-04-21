import { Component, OnInit } from '@angular/core';
import {Orders} from "../../../Entity/orders";
import {OrdersService} from "../../../Services/orders.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-orders',
  templateUrl: './add-orders.component.html',
  styleUrls: ['./add-orders.component.css']
})
export class AddOrdersComponent implements OnInit {

  redirect:boolean=false;

  constructor(private router:Router, private orderService:OrdersService )  { }

  redirectTo(){

    if(this.redirect == true ) {
      this.router.navigate(['orders']);
    }
  }

  createOrder() {

    const idInput = <HTMLInputElement>document.getElementById("Id");

    const id = idInput.valueAsNumber;

    const priceInput = <HTMLInputElement>document.getElementById("priceId");

    const price = priceInput.valueAsNumber;


    const detailsInput = <HTMLInputElement>document.getElementById("detailsId");

    const details = detailsInput.value;


    let order;
    if (id != null && price != null && details != null) {

      this.redirect=true;
      order = new Orders(id,NaN, price, details);
      this.orderService.saveOrder(order).subscribe((observer)=>{

        this.redirect=true;
        this.redirectTo();

      });
    }
  }


  ngOnInit(): void {
  }

}
