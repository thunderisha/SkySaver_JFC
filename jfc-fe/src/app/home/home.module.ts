import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page/home-page.component';
import { WhyChoseUsComponent } from './home-page/why-chose-us/why-chose-us.component';
import { TestimonialsComponent } from './home-page/testimonials/testimonials.component';



@NgModule({
  declarations: [
    HomePageComponent,
    WhyChoseUsComponent,
    TestimonialsComponent
  ],
  imports: [
    CommonModule
  ],exports:[
    HomePageComponent
  ]
})
export class HomeModule { }
