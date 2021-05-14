import { TestBed } from '@angular/core/testing';

import { StandingstabpathService } from './standingstabpath.service';

describe('StandingstabpathService', () => {
  let service: StandingstabpathService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StandingstabpathService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
