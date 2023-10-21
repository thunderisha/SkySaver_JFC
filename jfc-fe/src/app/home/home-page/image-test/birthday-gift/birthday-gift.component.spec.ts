import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BirthdayGiftComponent } from './birthday-gift.component';

describe('BirthdayGiftComponent', () => {
  let component: BirthdayGiftComponent;
  let fixture: ComponentFixture<BirthdayGiftComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BirthdayGiftComponent]
    });
    fixture = TestBed.createComponent(BirthdayGiftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
