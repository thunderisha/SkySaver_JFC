import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule } from '@angular/router';
import { SpinerComponent } from './spiner/spiner.component';



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    SpinerComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports:[
    HeaderComponent,
    FooterComponent,
    SpinerComponent
  ]
})
export class SharedModule { }
