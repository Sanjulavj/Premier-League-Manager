import {HttpClient} from "@angular/common/http";
import { Injectable } from '@angular/core';

import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class StandingstabpathService {



  constructor(private http:HttpClient) {
  }

  public standingsDataGet(){
    try {
      return this.http.get("http://localhost:4200/api/clubs").toPromise()
    } catch (error) {
      console.log(`[ERROR ==> getData ==> ${error.message}`,error);
      return null
    }
  }

}
