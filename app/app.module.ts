import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import {AppRoutingModule} from "./app-routing/app-routing.module";
import { NotFoundComponent } from './not-found/not-found.component';
import { OrdersComponent } from './orders/orders.component';
import { StockComponent } from './stock/stock.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { TasksComponent } from './tasks/tasks.component';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from "@angular/common/http";
import { ProductsComponent } from './products/products.component';
import { AddFormComponent } from './add-form/add-form.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AddOrdersComponent } from './orders/add-orders/add-orders.component';
import { AddProductsComponent } from './products/add-products/add-products.component';
import { UpdateorderComponent } from './orders/updateorder/updateorder.component';
import { UpdateProductComponent } from './products/update-product/update-product.component';
import { UserInterfaceComponent } from './user-interface/user-interface.component';
import { ShopComponent } from './shop/shop.component';
import { UserOrdersComponent } from './user-orders/user-orders.component';
import { UserHistoryComponent } from './user-history/user-history.component';
import { UserContactComponent } from './user-contact/user-contact.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { SeeOrderComponent } from './see-order/see-order.component';
import { SeeMoreDetailsComponent } from './see-order/see-more-details/see-more-details.component';
import { Comp1Component } from './comp1/comp1.component';




@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    UserComponent,
    NotFoundComponent,
    OrdersComponent,
    StockComponent,
    ContactUsComponent,
    TasksComponent,
    LoginComponent,
    ProductsComponent,
    AddFormComponent,
    UpdateUserComponent,
    AddOrdersComponent,
    AddProductsComponent,
    UpdateorderComponent,
    UpdateProductComponent,
    UserInterfaceComponent,
    ShopComponent,
    UserOrdersComponent,
    UserHistoryComponent,
    UserContactComponent,
    AboutUsComponent,
    SeeOrderComponent,
    SeeMoreDetailsComponent,
    Comp1Component

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
