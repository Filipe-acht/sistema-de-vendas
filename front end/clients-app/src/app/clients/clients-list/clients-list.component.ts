import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Client } from '../client';
import { ClientsService } from '../../clients.service';



@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {

  clients: Client[] = [];
  selectedClient: Client;
  sucessMessage: string;
  errorMessage: string;

  constructor(
    private service: ClientsService,
    private router: Router) { }

  ngOnInit(): void {
    this.service
      .getClients()
      .subscribe(response => this.clients = response);
  }

  newRegister() {
    this.router.navigate(['/clients/form']);
  }

  prepareDeletion(client: Client) {
    this.selectedClient = client;
  }

  deleteClient() {
    this.service
      .delete(this.selectedClient)
      .subscribe(response => {
        this.sucessMessage = 'Client successfully deleted!',
        this.ngOnInit();
      },
        errrorResponse => this.errorMessage = `An error occurred trying to delete the client ${this.selectedClient.name}!`)
  }
}
