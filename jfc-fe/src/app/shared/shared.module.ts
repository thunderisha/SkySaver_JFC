import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule } from '@angular/router';
import { SpinerComponent } from './spiner/spiner.component';
import { InformationComponent } from './information/information.component';



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    SpinerComponent,
    InformationComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports:[
    HeaderComponent,
    FooterComponent,
    SpinerComponent,
    InformationComponent
  ]
})
export class SharedModule { }
