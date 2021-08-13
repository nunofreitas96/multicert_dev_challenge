import { Component, OnInit } from '@angular/core';
import {Model} from "../client-search/client-search.component";

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {

  model: FormModel = new FormModel();
  constructor() { }

  ngOnInit(): void {
  }




}

export class FormModel{
  clientNameValue: string = "";
  nifValue: string = "";
  clientAddressValue: string = "";
  phoneNumberValue:string = "";
}
