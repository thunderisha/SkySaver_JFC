import { Component, OnInit } from '@angular/core';
import {MatGridListModule} from '@angular/material/grid-list';

@Component({
  selector: 'app-image-test',
  templateUrl: './image-test.component.html',
  styleUrls: ['./image-test.component.scss']
})
export class ImageTestComponent {

  statusLevelOfuser: string = "silver";
  nextNevelToReach: string = 'Gold'
  pointsCollected: number = 18;
  pointsToCollected: number = 7;
  flightNumber: number = 10;
  totalFlightnumberPerLevel = 25;
  priorityCheckInPointsLeft = 12
  loungeAccessPointsLeft = 10;
  freeSeatUpgreadPointsLeft = 20


  step = 1;


  quarterImage1 = 'path_to_quarter_1.jpg';
  quarterImage2 = 'path_to_quarter_2.jpg';
  quarterImage3 = 'path_to_quarter_3.jpg';
  quarterImage4 = 'path_to_quarter_4.jpg';

  nextStep() {
    if (this.step < 4) {
      this.step++;
    }
  }

  // subtitleFormat callback example
formatSubtitle = (percent: number) : string => {
  if(percent >= 100){
    return "Congratulations!"
  }else if(percent >= 50){
    return "Half"
  }else if(percent > 0){
    return "Just began"
  }else {
    return "Not started"
  }
}

  // previousStep() {
  //   if (this.step > 1) {
  //     this.step--;
  //   }
  // }

}
