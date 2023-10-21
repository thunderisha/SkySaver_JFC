import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page/home-page.component';
import { WhyChoseUsComponent } from './home-page/why-chose-us/why-chose-us.component';
import { TestimonialsComponent } from './home-page/testimonials/testimonials.component';
import { ImageTestComponent } from './home-page/image-test/image-test.component';
import { MaterialModule } from '../modules/material.module';
import { NgCircleProgressModule } from 'ng-circle-progress';



@NgModule({
  declarations: [
    HomePageComponent,
    WhyChoseUsComponent,
    TestimonialsComponent,
    ImageTestComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    NgCircleProgressModule.forRoot({
      // set defaults here
      // radius: 100,
      // outerStrokeWidth: 16,
      // innerStrokeWidth: 8,
      // outerStrokeColor: "#78C000",
      // innerStrokeColor: "#C7E596",
      // animationDuration: 30
    })
  ],exports:[
    HomePageComponent,
    ImageTestComponent
  ]
})
export class HomeModule { }
