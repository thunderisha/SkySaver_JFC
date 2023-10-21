import { Component, OnInit } from '@angular/core';
import { ServicesService } from 'src/app/core/services.service';

@Component({
  selector: 'app-image-test',
  templateUrl: './image-test.component.html',
  styleUrls: ['./image-test.component.scss']
})
export class ImageTestComponent implements OnInit{

  constructor(private servicesService: ServicesService) {

  }

  ngOnInit(): void {
    this.getProfilebyId()
    console.log("ktu")
  }

  getProfilebyId() {
    this.servicesService.getById(2).pipe().subscribe({
      next: (val) => {
        console.log("val", val);
      }
    })
  }

  step = 1;

  quarterImage1 = '';
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
