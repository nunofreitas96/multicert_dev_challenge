import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import {ClientSearchComponent} from "./client-search/client-search.component";
import {CreateClientComponent} from "./create-client/create-client.component";
import {ClientViewerComponent} from "./client-viewer/client-viewer.component";

export const routes: Routes = [
  { path: 'homepage', component: HomePageComponent},
  {path: 'client-search', component: ClientSearchComponent},
  {path: 'create-client', component: CreateClientComponent},
  {path: 'client-viewer', component: ClientViewerComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
