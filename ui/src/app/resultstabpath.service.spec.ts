import { TestBed } from '@angular/core/testing';

import { ResultstabpathService } from './resultstabpath.service';

describe('ResultstabpathService', () => {
  let service: ResultstabpathService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResultstabpathService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
