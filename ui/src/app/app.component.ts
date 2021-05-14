import { Component } from '@angular/core';
import {AppService} from "./app.service";
import {ResultstabpathService} from "./resultstabpath.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui';


   constructor(private appService: AppService) {

  }

  /**
   * This method is used to test the post request
   */






}
