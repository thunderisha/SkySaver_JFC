import { Component } from '@angular/core';
import { ServicesService } from 'src/app/core/services.service';

@Component({
  selector: 'app-my-rewards',
  templateUrl: './my-rewards.component.html',
  styleUrls: ['./my-rewards.component.scss']
})

export class MyRewardsComponent {
  rewardsList = [
      {
        "idreward": 1,
        "description": "5% Discount Hotel + Flight",
        "level": {
          "id": 1,
          "description": "Rookie",
          "endPoint": 20,
          "startPoint": 1
        }
      },
      {
        "idreward": 2,
        "description": "10% Discount + Priority Check In",
        "level": {
          "id": 2,
          "description": "Expert",
          "endPoint": 40,
          "startPoint": 20
        }
      },
      {
        "idreward": 3,
        "description": "10% Discount + Lounge Access ",
        "level": {
          "id": 3,
          "description": "Master",
          "endPoint": 60,
          "startPoint": 40
        }
      },
      {
        "idreward": 4,
        "description": "20% Discount + Free Seat Upgrade",
        "level": {
          "id": 4,
          "description": "Super Master",
          "endPoint": 80,
          "startPoint": 60
        }
      }
    ];

  constructor(private servicesService: ServicesService) { }

  ngOnInit(){
    this.getRewards()
  }

  getRewards() {
    this.servicesService.getRewards().pipe().subscribe({
      next: (val) => {
        console.log(val)
       this.rewardsList=val.data;
      }
    })
  }

}


