import { ChangeDetectorRef, Component } from '@angular/core';
import { LoaderService } from './loader.service';

@Component({
  selector: 'app-spiner',
  templateUrl: './spiner.component.html',
  styleUrls: ['./spiner.component.scss']
})
export class SpinerComponent {
  constructor(public loader: LoaderService,
    private cdref: ChangeDetectorRef ) { }

    ngAfterContentChecked() {
      this.cdref.detectChanges();
   }
}
