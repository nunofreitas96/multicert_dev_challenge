import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-client-search',
  templateUrl: './client-search.component.html',
  styleUrls: ['./client-search.component.css']
})

export class ClientSearchComponent implements OnInit {
  clientResults = [];
  model: Model = new Model();
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient) { }


  ngOnInit(): void {
    this.http.get<any>('http://localhost:8080/clients').subscribe(data => {
      this.clientResults = data;

    })
  }

  search(): void{
    if(this.model.typeValue == "nif"){
      this.http.get<any>('http://localhost:8080/client/' + this.model.typedValue).subscribe(data => {

        this.clientResults = data;
        if(this.clientResults.length == 0){
          alert("No data found!")
        }

      })
    }else if(this.model.typeValue == "name"){
      this.http.get<any>('http://localhost:8080/clients/' + this.model.typedValue).subscribe(data => {

        this.clientResults = data;
        if(this.clientResults.length == 0){
          alert("No data found!")
        }

      })
    }}

  DeleteClient(cid:number): void{
    this.http.delete('http://localhost:8080/deleteclient/' + cid).subscribe(data => {
      this.http.get<any>('http://localhost:8080/clients').subscribe(data => {
        this.clientResults = data;
      })
    })
  }


}

export class Model{
  typeValue: string = "nif";
  typedValue: string = "";
}

