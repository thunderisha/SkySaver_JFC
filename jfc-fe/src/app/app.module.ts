import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SharedModule } from './shared/shared.module';
import { MaterialModule } from './modules/material.module';
import { HomeModule } from './home/home.module';
import { CoreModule } from './core/core.module';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoadingInterceptor } from './loading.interceptor';
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
    CoreModule
    // Specify ng-circle-progress as an import

  ],
  providers: [
  
    {
      provide: HTTP_INTERCEPTORS, useClass: LoadingInterceptor, multi: true
    }
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
