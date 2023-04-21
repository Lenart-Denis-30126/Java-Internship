import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserComponent} from "../user/user.component";
import {Routes, RouterStateSnapshot, Router, RouterModule} from "@angular/router";
import {AdminComponent} from "../admin/admin.component";
import {NotFoundComponent} from "../not-found/not-found.component";
import {OrdersComponent} from "../orders/orders.component";
import {StockComponent} from "../stock/stock.component";
import {ContactUsComponent} from "../contact-us/contact-us.component";
import {TasksComponent} from "../tasks/tasks.component";
import {LoginComponent} from "../login/login.component";
import {ProductsComponent} from "../products/products.component";
import {AddFormComponent} from "../add-form/add-form.component";
import {UpdateUserComponent} from "../user/update-user/update-user.component";
import {AddOrdersComponent} from "../orders/add-orders/add-orders.component";
import {AddProductsComponent} from "../products/add-products/add-products.component";
import {UpdateorderComponent} from "../orders/updateorder/updateorder.component";
import {UpdateProductComponent} from "../products/update-product/update-product.component";
import {UserInterfaceComponent} from "../user-interface/user-interface.component";
import {ShopComponent} from "../shop/shop.component";
import {UserOrdersComponent} from "../user-orders/user-orders.component";
import {UserHistoryComponent} from "../user-history/user-history.component";
import {UserContactComponent} from "../user-contact/user-contact.component";
import {AboutUsComponent} from "../about-us/about-us.component";
import {SeeOrderComponent} from "../see-order/see-order.component";
import {SeeMoreDetailsComponent} from "../see-order/see-more-details/see-more-details.component";



const routes: Routes=[
  {path:'management', component : AdminComponent},
  {path:'users', component : UserComponent},
  {path:'orders', component : OrdersComponent},
  {path:'stock', component : StockComponent},
  {path:'contact', component : ContactUsComponent},
  {path:'tasks',component : TasksComponent},
  {path:'login',component: LoginComponent},
  {path:'products', component: ProductsComponent},
  {path:'addForm', component: AddFormComponent},
  {path:'userUpdate', component: UpdateUserComponent},
  {path:'addOrder', component: AddOrdersComponent},
  {path:'addProduct', component: AddProductsComponent},
  {path:'updateOrder', component: UpdateorderComponent},
  {path:'updateProduct', component: UpdateProductComponent},
  {path:'interface', component:UserInterfaceComponent},
  {path:'shop', component: ShopComponent},
  {path:'userOrders', component: UserOrdersComponent},
  {path:'userHistory', component: UserHistoryComponent},
  {path:'userContact', component: UserContactComponent},
  {path:'aboutUs', component: AboutUsComponent},
  {path:'myOrder', component: SeeOrderComponent},
  {path:'moreOrder', component: SeeMoreDetailsComponent},
  {path:'**',component : NotFoundComponent}
// path:'**' wildcard pentru endpoints gresite
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)

  ],
  exports: [
    RouterModule

  ]
})
export class AppRoutingModule { }
