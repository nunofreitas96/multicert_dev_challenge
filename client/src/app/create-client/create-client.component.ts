import { Component, OnInit } from '@angular/core';
import {Model} from "../client-search/client-search.component";
import {HttpClient, HttpHeaders} from "@angular/common/http";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    Authorization: 'my-auth-token'
  })};

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})


export class CreateClientComponent implements OnInit {


  model: FormModel = new FormModel();
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }


  createClient() {

    this.model.clientNif = "" + this.model.clientNif;

    this.model.phoneNumber = "" + this.model.phoneNumber;

    if (this.model.clientName == "") {
      alert("No client name typed!")
      return
    }
    if (this.model.clientAddress == "") {
      alert("No address typed!")
      return
    }
    if (this.model.clientNif.toString().length != 9) {
      alert("NIF does not have correct number of digits!")
      return
    }
    if (this.model.phoneNumber.length != 9) {
      alert("Phone Number does not have correct number of digits!")
      return
    }


    this.http.post<any>('http://localhost:8080/addclient', this.model, httpOptions).subscribe(data => {
      location.reload();
    });

  }


}

export class FormModel{
  clientName: string = "";
  clientNif: string = "";
  clientAddress: string = "";
  phoneNumber:string = "";
}
