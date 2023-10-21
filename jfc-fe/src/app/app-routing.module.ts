import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ImageTestComponent } from './home/home-page/image-test/image-test.component';
import { HomePageComponent } from './home/home-page/home-page.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent},
  { path: 'sky-gift', component: ImageTestComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
