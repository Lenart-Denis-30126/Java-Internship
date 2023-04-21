import { Component, OnInit } from '@angular/core';
import {Orders} from "../../../Entity/orders";
import {OrdersService} from "../../../Services/orders.service";
import {Products} from "../../../Entity/products";
import {ProductsService} from "../../../Services/products.service";
import {Users} from "../../../Entity/users";
import {UserService} from "../../../Services/user.service";

export interface Dessert {
  calories: number;
  carbs: number;
  fat: number;
  name: string;
  protein: number;
}

@Component({
  selector: 'app-see-more-details',
  templateUrl: './see-more-details.component.html',
  styleUrls: ['./see-more-details.component.scss']
})
export class SeeMoreDetailsComponent implements OnInit {

  products:Array<Products> = [];
  orders:Array<Orders>=[];
  users:Array<Users>=[];

  constructor(private userService:UserService, private productService:ProductsService, private orderService:OrdersService) { }

  getAllUsers(){

    this.userService.grabAllUsers().subscribe(users => {

      this.users=users;
      console.log(users);
    });

  }

  deleteUser(users:Users){

    this.userService.deleteUsers(users).subscribe((observer)=>{

      this.getAllUsers();

    })



  }

  updateUser(users:Users){
    this.userService.updateUsers(users).subscribe(()=>{
      console.log("User updated!")
    } )

  }


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

  getUserByUsername(username:string){

    this.userService.grabByUsername(username).subscribe(user=>{

      this.users=user;
      }
    )}

  getOrderUserId(username:String){

    this.orderService.grabOrderByUserUsername(username).subscribe(order=>{

      return username;

    })

  }



  ngOnInit(): void {
    this.getAllOrders();
    this.getAllUsers();
    this.getAllProducts();

  }
}
