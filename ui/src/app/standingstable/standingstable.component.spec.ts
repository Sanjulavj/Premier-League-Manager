import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StandingstableComponent } from './standingstable.component';

describe('StandingstableComponent', () => {
  let component: StandingstableComponent;
  let fixture: ComponentFixture<StandingstableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StandingstableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StandingstableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
