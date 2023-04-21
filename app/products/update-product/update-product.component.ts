import { Component, OnInit } from '@angular/core';
import {Products} from "../../../Entity/products";
import {ProductsService} from "../../../Services/products.service";

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  products:Array<Products> = [];

  constructor(private productService: ProductsService ) { }

  getAllProducts(){

    this.productService.grabAllProducts().subscribe(product => {

      this.products=product;

    });

  }

  fetchProduct() {

    const idInput = <HTMLSelectElement>document.getElementById("selectId");

    const id:number = +idInput.value;

    this.productService.grabProductById(id).subscribe(product => {

        const nameInput = <HTMLInputElement>document.getElementById("nameId");

        nameInput.value = String(product.name);

        const descInput = <HTMLInputElement>document.getElementById("descId");

        descInput.value = String(product.description);


        const stockInput = <HTMLInputElement>document.getElementById("stockId");

        stockInput.value = String(product.stock);

        const priceInput = <HTMLInputElement>document.getElementById("priceId");

        priceInput.value = String(product.price);


      }
    )

  }

  updateOrder(){

    const idInput = <HTMLSelectElement>document.getElementById("selectId");

    const id:number = +idInput.value;

    this.productService.grabProductById(id).subscribe(product => {

        const nameInput = <HTMLInputElement>document.getElementById("nameId");

      product.name= nameInput.value

        const descInput = <HTMLInputElement>document.getElementById("descId");

      product.description=descInput.value;


        const stockInput = <HTMLInputElement>document.getElementById("stockId");

      product.stock= stockInput.valueAsNumber;

        const priceInput = <HTMLInputElement>document.getElementById("priceId");

      product.price=priceInput.valueAsNumber;

    this.productService.updateProduct(product).subscribe();
      }
    )

  }


  ngOnInit(): void {
    this.getAllProducts();
  }

}
