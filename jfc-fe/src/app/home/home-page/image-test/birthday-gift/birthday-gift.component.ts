
import { Component } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-birthday-gift',
  templateUrl: './birthday-gift.component.html',
  styleUrls: ['./birthday-gift.component.scss']
})
export class BirthdayGiftComponent {
  //date: string; // Define 'date' as a string

  isDisabled: boolean = false;
   format1 = "YYYY-MM-DD"
  constructor() {
    const today = new Date(); // Get today's date
    console.log(today)
    let myMoment= moment(today).format(this.format1);;
    console.log(myMoment)
    //this.date = this.datePipe.transform(today, 'yyyy-MM-dd');
  }
}
