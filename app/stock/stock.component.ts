import { Component, OnInit } from '@angular/core';

import {Products} from "../../Entity/products";
import {ProductsService} from "../../Services/products.service";
import {Orders} from "../../Entity/orders";
import {OrdersService} from "../../Services/orders.service";


@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  products:Array<Products> = [];
  orders:Array<Orders>=[];

  constructor(private productService:ProductsService, private orderService:OrdersService) { }

  getAllProducts(){

    this.productService.grabAllProducts().subscribe(product => {

      this.products=product;

    });

  }

  deleteProducts(product:Products){


      this.productService.deleteProduct(product).subscribe();


  }

  getAllOrders() {

    this.orderService.grabAllOrders().subscribe(order => {

      this.orders = order;

    });
  }

  ngOnInit(): void {
  this.getAllProducts();
  this.getAllOrders();

  }


}
