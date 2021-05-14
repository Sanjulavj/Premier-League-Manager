import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'

})

export class ResultstabpathService {


  constructor(private  http:HttpClient) {
  }

    public resultsDataGet(){
      try {
        return this.http.get("http://localhost:4200/api/matches").toPromise()
      } catch (error) {
        console.log(`[ERROR ==> getData ==> ${error.message}`,error);
        return null
      }
    }



}



