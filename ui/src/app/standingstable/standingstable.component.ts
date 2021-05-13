import {Component, OnInit, ViewChild} from '@angular/core';

import {MatTableDataSource} from "@angular/material/table";
//import {MatSort} from '@angular/material/sort';
import {StandingstabpathService} from "../standingstabpath.service";
import {NgForm} from "@angular/forms";



export interface MyInterface {
  sportsClubName:string;
  sportsClubLocation:string;
  points: number;
  numMatches: number;
  wins: number;
  draws: number;
  defeats:number;
  goalsFor: number;
  goalsAgainst: number;


}

let clubDataList: MyInterface[] = [];


@Component({
  selector: 'app-standingstable',
  templateUrl: './standingstable.component.html',
  styleUrls: ['./standingstable.component.css']
})
export class StandingstableComponent implements OnInit {
  //assining column table
  displayedColumns: string[] = ['sportsClubName','numMatches','wins','draws','defeats','goalsFor','goalsAgainst','goalsDifference','points'];
  dataSource:any;


  constructor(private service:StandingstabpathService) {
  }

  ngOnInit(): void {
    this.getAllStandings();
    //this.dataSource.sort = this.sort;
  }

  //adding club to the table
  public async getAllStandings(){
    try {
      //empty list
      clubDataList=[];
      const details: any = await this.service.standingsDataGet();
      console.log(details)
      //looping through the array
      for (const i in details){
        clubDataList.push({ sportsClubName:details[i]["sportsClubName"],sportsClubLocation: details[i]["sportsClubLocation"],points: details[i]["points"],numMatches: details[i]["numMatches"],wins: details[i]["wins"],draws: details[i]["draws"],defeats: details[i]["defeats"],goalsFor: details[i]["goalsFor"],goalsAgainst: details[i]["goalsAgainst"]});


      }
      //adding datasoure to the club table
       this.dataSource=new MatTableDataSource(clubDataList);
       console.log(clubDataList);


    } catch (error) {
      console.log("Error occurs in clubTable",error)

    }

  }

  //sorting for goals scored
  public sortGoalsFor(){
    //calling the table list
    this.dataSource=new MatTableDataSource(clubDataList);

    //looping throgh list
    for(var i1=1;i1< clubDataList.length;i1++){
      var value=clubDataList[i1].goalsFor;
      var item=clubDataList[i1];
      var k=i1-1;
      //looping throgh the array
      while(k>=0 && clubDataList[k].goalsFor>value){
        clubDataList[k+1]=clubDataList[k];
        k--;

      }
      //assining club datalist
      clubDataList[k+1]=item;

    }
    console.log(clubDataList);
    //adding reveresed data to the table
    this.dataSource=new MatTableDataSource(clubDataList.reverse());

  }

//method to sort for wins
  public sortWins(){
    this.dataSource=new MatTableDataSource(clubDataList);

    for(var k=1;k< clubDataList.length;k++){
      var value=clubDataList[k].wins;
      var item=clubDataList[k];
      var k2=k-1;
      while(k2>=0 && clubDataList[k2].wins>value){
        clubDataList[k2+1]=clubDataList[k2];
        k2--;
      }
    //assining club data list
      clubDataList[k2+1]=item;

    }
    console.log(clubDataList);
    //adding reveresed data to the table
    this.dataSource=new MatTableDataSource(clubDataList.reverse());

  }


}
