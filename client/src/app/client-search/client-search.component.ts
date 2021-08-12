import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-client-search',
  templateUrl: './client-search.component.html',
  styleUrls: ['./client-search.component.css']
})
export class ClientSearchComponent implements OnInit {
  clientResults = [];
  constructor(
    private http: HttpClient) { }


  ngOnInit(): void {
    this.http.get<any>('http://localhost:8080/clients').subscribe(data => {
      this.clientResults = data;
      console.log(this.clientResults);
    })
  }
}
