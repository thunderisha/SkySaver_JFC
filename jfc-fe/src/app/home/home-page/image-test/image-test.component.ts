import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Subject, take, takeUntil } from 'rxjs';
import { ServicesService } from 'src/app/core/services.service';

@Component({
  selector: 'app-image-test',
  templateUrl: './image-test.component.html',
  styleUrls: ['./image-test.component.scss']
})
export class ImageTestComponent implements OnInit, OnDestroy{

  private onDestroy$: Subject<void> = new Subject<void>();
  step = 1;
  dataUserById: any
  dataUrl!: string
  myBlob!: Blob;
  safeImageUrl: any;
  // quarterImage1 = 'path_to_quarter_1.jpg';
  // quarterImage2 = 'path_to_quarter_2.jpg';
  // quarterImage3 = 'path_to_quarter_3.jpg';
  // quarterImage4 = 'path_to_quarter_4.jpg';

  quarterImage1 = '';
  quarterImage2 = 'path_to_quarter_2.jpg';
  quarterImage3 = 'path_to_quarter_3.jpg';
  quarterImage4 = 'path_to_quarter_4.jpg';

  constructor(private servicesService: ServicesService,private sanitizer: DomSanitizer) {

  }

  ngOnInit(): void {
    this.getProfilebyId()
    console.log("ktu")
  }

  getProfilebyId() {
    this.servicesService.getById(2).pipe(
      take(1),
      takeUntil(this.onDestroy$)
    ).subscribe({
      next: (val) => {
        this.dataUserById = val.data
        console.log("val", this.dataUserById );
        //this.myBlob = new Blob([this.dataUserById.puzzleFiles[0].blob], { type: 'image/jpeg' });
        let objectURL = 'data:image/jpeg;base64,' + this.dataUserById.puzzleFiles[0].blob;
        this.safeImageUrl = this.sanitizer.bypassSecurityTrustUrl(objectURL)
        console.log(this.safeImageUrl)
          // element['thumbnail'] = this.sanitizer.bypassSecurityTrustUrl(objectURL);
      }
    })
  }



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

  ngOnDestroy(): void {
    this.onDestroy$.next();
    this.onDestroy$.complete();
  }

}
