import { Component, OnInit } from '@angular/core';
import { Client } from '../../clients/clients';
import { ClientsService } from '../../clients.service';
import { ServiceProvided } from '../serviceProvided';

@Component({
  selector: 'app-service-provided-form',
  templateUrl: './service-provided-form.component.html',
  styleUrls: ['./service-provided-form.component.css']
})
export class ServiceProvidedFormComponent implements OnInit {

  clients: Client[] = [];
  service: ServiceProvided;
  constructor(
    private clientsService: ClientsService
  ) { 
    this.service = new ServiceProvided();
  }

  // a tela já é carregada com uma listagem de clients
  ngOnInit(): void {
    this.clientsService
      .getClients()
      .subscribe(response => this.clients = response);
  }

  onSubmit(){
    console.log(this.service);
  }
}
