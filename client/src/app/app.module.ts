import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { NavbarComponent } from './navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ClientViewerComponent } from './client-viewer/client-viewer.component';
import { ClientSearchComponent } from './client-search/client-search.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CreateClientComponent } from './create-client/create-client.component';
import {RouterModule} from "@angular/router";
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ClientViewerComponent,
    ClientSearchComponent,
    HomePageComponent,
    CreateClientComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
