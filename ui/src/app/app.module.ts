import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from "@angular/router";
//import { DataTableModule } from 'angular5-data-table';
import {MatTableModule} from '@angular/material/table';
import {HttpClientModule} from "@angular/common/http";
//import {HttpClientModule} from "@angular/common/http";
import {MatSortModule} from "@angular/material/sort";
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { NavbarComponent } from './navbar/navbar.component';
import { ResultsComponent } from './results/results.component';
import { StandingsComponent } from './standings/standings.component';
import { ResultstableComponent } from './resultstable/resultstable.component';
import { StandingstableComponent } from './standingstable/standingstable.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatPaginatorModule} from "@angular/material/paginator";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";



//import {HttpClient, HttpClientModule} from "@angular/common/http";
// import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
//import { HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent,
    ResultsComponent,
    StandingsComponent,
    ResultstableComponent,
    StandingstableComponent
  ],
  imports: [
    BrowserModule,
    //DataTableModule,
    MatTableModule,
    HttpClientModule,
    MatSortModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path: '', component: StandingsComponent},
      {path: 'results', component: ResultsComponent}
    ]),
    MatFormFieldModule,
    MatPaginatorModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {

}
