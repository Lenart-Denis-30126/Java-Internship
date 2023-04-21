import { Component, OnInit } from '@angular/core';
import {Orders} from "../../../Entity/orders";
import {ProductsService} from "../../../Services/products.service";
import {Products} from "../../../Entity/products";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css']
})
export class AddProductsComponent implements OnInit {

  redirect:boolean=false;

  constructor(private router:Router, private productsService: ProductsService) { }

  redirectTo(){

    if(this.redirect == true ) {
      this.router.navigate(['products']);
    }
  }


  createProduct() {


    const nameInput = <HTMLInputElement>document.getElementById("nameId");

    const name = nameInput.value;

    const descInput = <HTMLInputElement>document.getElementById("descId");

    const description = descInput.value;


    const stockInput = <HTMLInputElement>document.getElementById("stockId");

    const stock = stockInput.valueAsNumber;


    const priceInput = <HTMLInputElement>document.getElementById("priceId");

    const price = priceInput.valueAsNumber;

    if ( name!="" && description != "" && stock != null && price != null) {
      let product: Products = new Products(NaN,name,description,stock,price);
      this.productsService.createProduct(product).subscribe((observer)=>{

        this.redirect=true;
        this.redirectTo();


      });
    }
  }


  ngOnInit(): void {
  }

}
