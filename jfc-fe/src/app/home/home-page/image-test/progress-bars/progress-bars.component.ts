import { Component, Input, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-progress-bars',
  templateUrl: './progress-bars.component.html',
  styleUrls: ['./progress-bars.component.scss']
})
export class ProgressBarsComponent implements OnInit{
  statusLevelOfuser: string = "silver";
  nextNevelToReach: string = 'Gold'
  pointsCollected: number = 18;
  pointsToCollected: number = 7;
  flightNumber: number = 10;
  totalFlightnumberPerLevel = 25;
  priorityCheckInPointsLeft = 12
  loungeAccessPointsLeft = 10;
  freeSeatUpgreadPointsLeft = 20


  @Input() points!: number;
  @Input() endPoint!: number;

 percentageOfStatus!: number

 constructor() {

 }

 ngOnInit(): void {
  this.percentageOfStatus = this.points / this.endPoint
}

}
