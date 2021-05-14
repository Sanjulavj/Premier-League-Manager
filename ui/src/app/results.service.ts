import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ResultsService {
 // private randomMatchUrl = '/api/randomMatch';

  constructor(private  http:HttpClient) { }

  public randomMatchGet(){
    try {
      return this.http.get("http://localhost:4200/api/randomMatch").toPromise()
    } catch (error) {
      console.log(`[ERROR ==> getData ==> ${error.message}`,error);
      return null
    }

  }
}
