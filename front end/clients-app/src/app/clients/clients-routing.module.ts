import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientsFormComponent } from './clients-form/clients-form.component';
import { ClientsListComponent } from './clients-list/clients-list.component';
import { LayoutComponent } from '../layout/layout.component';


const routes: Routes = [
  {
    path: 'clients', component: LayoutComponent, children: [
      { path: 'form', component: ClientsFormComponent },
      { path: 'form/:id', component: ClientsFormComponent },
      { path: 'list', component: ClientsListComponent },
      { path: '', redirectTo: '/clients/list', pathMatch: 'full' }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientsRoutingModule { }
