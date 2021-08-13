import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-client-viewer',
  templateUrl: './client-viewer.component.html',
  styleUrls: ['./client-viewer.component.css']
})
export class ClientViewerComponent implements OnInit {
  clientResults = [];
  constructor(
    private http: HttpClient) { }


  ngOnInit(): void {
    this.http.get<any>('http://localhost:8080/clients').subscribe(data => {
      this.clientResults = data;
      console.log(this.clientResults);
    })
  }

  DeleteClient(cid:number): void{
    this.http.delete('http://localhost:8080/deleteclient/' + cid).subscribe(data => {
      this.http.get<any>('http://localhost:8080/clients').subscribe(data => {
        this.clientResults = data;
      })
    })
  }



}
