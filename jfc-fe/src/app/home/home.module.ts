import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { CoreModule } from '../core/core.module';
import { BirthdayGiftComponent } from './home-page/image-test/birthday-gift/birthday-gift.component';
import { MaterialModule } from '../modules/material.module';
import { HomePageComponent } from './home-page/home-page.component';
import { ImageTestComponent } from './home-page/image-test/image-test.component';
import { ProgressBarsComponent } from './home-page/image-test/progress-bars/progress-bars.component';
import { MyBookingsComponent } from './home-page/my-bookings/my-bookings.component';
import { MyRewardsComponent } from './home-page/my-rewards/my-rewards.component';
import { TestimonialsComponent } from './home-page/testimonials/testimonials.component';
import { WhyChoseUsComponent } from './home-page/why-chose-us/why-chose-us.component';



@NgModule({
  declarations: [
    HomePageComponent,
    WhyChoseUsComponent,
    TestimonialsComponent,
    ImageTestComponent,
    ProgressBarsComponent,
    BirthdayGiftComponent,
    
    MyBookingsComponent,
    MyRewardsComponent
  ],
  imports: [
    CommonModule,
    CoreModule,
    MaterialModule,
    NgCircleProgressModule.forRoot({
      // set defaults here
      // radius: 100,
      // outerStrokeWidth: 16,
      // innerStrokeWidth: 8,
      // outerStrokeColor: "#78C000",
      // innerStrokeColor: "#C7E596",
      // animationDuration: 30
    }),
    
  ],exports:[
    HomePageComponent,
    ImageTestComponent
  ]
})
export class HomeModule { }
