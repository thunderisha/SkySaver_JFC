import { Component } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { data } from 'jquery';
import { ServicesService } from 'src/app/core/services.service';
import { InformationComponent } from 'src/app/shared/information/information.component';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {

  userDTO: any = {};
  constructor(private servicesService: ServicesService,private dialog: MatDialog,) {

  }


  updateBooking() {
    this.servicesService.fetchContent().subscribe({
      next: (val) => {
        this.userDTO = val;
        this.servicesService.updateBook(this.userDTO).pipe().subscribe({
          next: (val) => {
            console.log("val", val);
          }
        })
      }
    })

  }

}
