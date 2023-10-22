import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BirthdayPopupComponent } from './birthday-popup.component';

describe('BirthdayPopupComponent', () => {
  let component: BirthdayPopupComponent;
  let fixture: ComponentFixture<BirthdayPopupComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BirthdayPopupComponent]
    });
    fixture = TestBed.createComponent(BirthdayPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
