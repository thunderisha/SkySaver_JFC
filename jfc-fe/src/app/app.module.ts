import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SharedModule } from './shared/shared.module';
import { MaterialModule } from './modules/material.module';
import { HomeModule } from './home/home.module';

import { ImageTestComponent } from './home/home-page/image-test/image-test.component';
// Import ng-circle-progress
import { NgCircleProgressModule } from 'ng-circle-progress';
@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SharedModule,
    MaterialModule,
    HomeModule,
    // Specify ng-circle-progress as an import
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
