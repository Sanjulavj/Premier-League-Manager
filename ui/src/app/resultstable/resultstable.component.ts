import {Component, OnInit, ViewChild} from '@angular/core';
import { ResultstabpathService } from '../resultstabpath.service';
//import { Resultsreports} from "../../resultsreports";
import {MatTableDataSource} from "@angular/material/table";
import {ResultsService} from "../results.service";
import {MatSort} from "@angular/material/sort";
import {NgForm} from "@angular/forms";


export interface ResultsTable {
  team1: string;
  team2: string;
  team1Goals: number;
  team2Goals: number;
  matchLocation: string;
  matchDate: any;
  matchYear: string;
  matchMonth:string;
  matchDay:string;

}


//assigning interface data to the list
let  resultsDataList:ResultsTable[]=[];


@Component({
  selector: 'app-resultstable',
  templateUrl: './resultstable.component.html',
  styleUrls: ['./resultstable.component.css']
})



export class ResultstableComponent implements OnInit{

  //calling constructor
  constructor(private service:ResultstabpathService,private service2:ResultsService) {

  }

//assigning collumn headers
  displayedColumns: string[] = ['matchDate','matchLocation','team1','team1Goals','team2Goals','team2'];
  dataSource:any;


   ngOnInit() {
     this.getAllResults();


   }



//adding backend data to the datasource
  async getAllResults() {
     //try catch for error handling
    try {
      //clearing all data in the list
      resultsDataList=[];
      //getting backend url to the data const
      const dataList1: any = await this.service.resultsDataGet();
      console.log("a",dataList1)
      //looping through data
      for (var i in dataList1) {
        //adding data to the list
        resultsDataList.push({
          team1: dataList1[i]["team1"],
          team2: dataList1[i]["team2"],
          team1Goals: dataList1[i]["team1Goals"],
          team2Goals: dataList1[i]["team2Goals"],
          matchLocation: dataList1[i]["matchLocation"],
          matchDate: dataList1[i]["matchDate"],
          matchDay: dataList1[i]["matchDay"],
          matchMonth: dataList1[i]["matchMonth"],
          matchYear: dataList1[i]["matchYear"]
        });
      }
      console.log(resultsDataList)
      //adding datasource to the table
      this.dataSource=new MatTableDataSource(resultsDataList);
      console.log(resultsDataList);


    } catch (error) {
      console.log("Error occurs",error)

    }

    console.log(resultsDataList);

  }

  //creating random match
  async randomMatch(){
    //try catch for error handling
    try {
      //clearing all data in the list
      resultsDataList = [];
      const datalist2: any = await this.service2.randomMatchGet();
      //looping throgh the ist
      for (var i in datalist2) {
        //adding data to lis
        resultsDataList.push({
          team1: datalist2[i]["team1"],
          team2: datalist2[i]["team2"],
          team1Goals: datalist2[i]["team1Goals"],
          team2Goals: datalist2[i]["team2Goals"],
          matchLocation: datalist2[i]["matchLocation"],
          matchDate: datalist2[i]["matchDate"],
          matchDay: datalist2[i]["matchDay"],
          matchMonth: datalist2[i]["matchMonth"],
          matchYear: datalist2[i]["matchYear"]
        });

      }

    //adding datasource to the table
      this.dataSource = new MatTableDataSource(resultsDataList);
      console.log(this.dataSource);
      console.log(resultsDataList);
    }catch (e) {
      console.log("Error in random match",e)
    }

  }


//creating match date sort
  public matchDateSort(){
    this.dataSource=new MatTableDataSource(resultsDataList);
//looping throgh array to get the data
    for(var k1=1;k1< resultsDataList.length;k1++){
      var value=resultsDataList[k1].matchDate.matchDay+resultsDataList[k1].matchDate.matchMonth*32+resultsDataList[k1].matchDate.matchYear*416;
      //var value2=ELEMENT_DATA[i].matchDate.matchMonth;
      console.log(value)
      var item=resultsDataList[k1];
      var k=k1-1;
      while(k>=0 && resultsDataList[k].matchDate.matchDay+resultsDataList[k].matchDate.matchMonth*32+resultsDataList[k].matchDate.matchYear*416>value  ){
        resultsDataList[k+1]=resultsDataList[k];
        k--;
      }


      resultsDataList[k+1]=item;

    }
    console.log(resultsDataList);
    this.dataSource=new MatTableDataSource(resultsDataList);


  }

//method to search from the date
  searchForDate(f:NgForm){
     console.log("opens search")
    let list =[]
    let list2 =[]
    let dateCheck =f.value.search;
     console.log(dateCheck)
    //looping through list for date
    for (var i in resultsDataList){
      var dateItem = resultsDataList[i].matchDate.matchYear+"-"+ resultsDataList[i].matchDate.matchMonth+"-"+ resultsDataList[i].matchDate.matchDay;
      console.log(dateItem)
       if(dateItem == dateCheck){
         //adding data to the table
         list.push(resultsDataList[i])

       }

      for (var j in resultsDataList[i].matchDate){
        console.log(j)
        list2.push({matchDay:resultsDataList[i].matchDate[j]["matchDay"],matchMonth:resultsDataList[i].matchDate[j]["matchMonth"],matchYear:resultsDataList[i].matchDate[j]["matchYear"]})

      }


    }
    console.log(list2)
    if(list.length==0){
      //adding data source to the table
      this.dataSource=new MatTableDataSource(resultsDataList)
    }else {
      this.dataSource=new MatTableDataSource(list)
    }
  }


}
