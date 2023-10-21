import { Component } from '@angular/core';
import { ServicesService } from 'src/app/core/services.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {

  userDTO: any = {};
  constructor(private servicesService: ServicesService) {

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
