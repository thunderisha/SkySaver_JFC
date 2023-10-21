import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import 'bootstrap';


@Component({
  selector: 'app-testimonials',
  templateUrl: './testimonials.component.html',
  styleUrls: ['./testimonials.component.scss']
})
export class TestimonialsComponent  implements AfterViewInit{
  @ViewChild('testimonial-slider', { static: false }) myElementRef!: ElementRef;
 
  ngAfterViewInit() {
    //const nativeElement = this.myElementRef.nativeElement as HTMLElement;
    // console.log(this.myElementRef)
   // nativeElement.style.display = 'none';
  }
}
