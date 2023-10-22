
import { Component } from '@angular/core';
import * as moment from 'moment';
import { Subject, take, takeUntil } from 'rxjs';
import { ServicesService } from 'src/app/core/services.service';

@Component({
  selector: 'app-birthday-gift',
  templateUrl: './birthday-gift.component.html',
  styleUrls: ['./birthday-gift.component.scss']
})
export class BirthdayGiftComponent {
  //date: string; // Define 'date' as a string
 
  isDisabled!: boolean ;
   format1 = "YYYY-MM-DD"
  constructor(private servicesService: ServicesService) {
    const today = new Date(); // Get today's date
    console.log(today)
    let myMoment= moment(today).format(this.format1);;
    console.log(myMoment)
    //this.date = this.datePipe.transform(today, 'yyyy-MM-dd');
  }
  ngOnInit(){
    this.getBDyId()
  }

  getBDyId() {
    this.servicesService.getBDyId(3).pipe().subscribe({
      next: (val) => {
        console.log(val)
        this.isDisabled=val.data;
      }
    })
  }
  
}
