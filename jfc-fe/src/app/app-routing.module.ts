import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home/home-page/home-page.component';
import { ImageTestComponent } from './home/home-page/image-test/image-test.component';
import { MyBookingsComponent } from './home/home-page/my-bookings/my-bookings.component';
import { MyRewardsComponent } from './home/home-page/my-rewards/my-rewards.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent},
  { path: 'sky-gift', component: ImageTestComponent },
  { path: 'my-bookings', component: MyBookingsComponent },
  { path: 'my-rewards', component: MyRewardsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
