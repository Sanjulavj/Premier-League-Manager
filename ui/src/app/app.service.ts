import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AppService {


  constructor(private http: HttpClient) {
  }


  /**
   * Makes a http post request to send some data to backend & get response.
   */

}
