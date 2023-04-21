import { Component, OnInit } from '@angular/core';

import {Products} from "../../Entity/products";
import {ProductsService} from "../../Services/products.service";

@Component({
  selector: 'app-user',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products:Array<Products> = [];

  constructor(private productService: ProductsService ) { }

  getAllProducts(){

    this.productService.grabAllProducts().subscribe(product => {

      this.products=product;

    });

  }

  deleteProducts(products:Products){

    this.productService.deleteProduct(products).subscribe((observer)=>{

      this.getAllProducts();

    });

  }

  ngOnInit(): void {
    this.getAllProducts();
  }

}
