import { Component, OnInit } from '@angular/core';
import { Client } from '../../clients/clients';
import { ClientsService } from '../../clients.service';
import { ServiceProvidedService } from '../../service-provided.service';
import { ServiceProvided } from '../serviceProvided';

@Component({
  selector: 'app-service-provided-form',
  templateUrl: './service-provided-form.component.html',
  styleUrls: ['./service-provided-form.component.css']
})
export class ServiceProvidedFormComponent implements OnInit {

  clients: Client[] = [];
  service: ServiceProvided;
  success: boolean = false;
  errors: String[];


  constructor(
    private clientsService: ClientsService,
    private serviceProvided: ServiceProvidedService
  ) {
    this.service = new ServiceProvided();
  }

  // a tela já é carregada com uma listagem de clients
  ngOnInit(): void {
    this.clientsService
      .getClients()
      .subscribe(response => this.clients = response);
  }

  onSubmit() {
    this.serviceProvided
      .save(this.service)
      .subscribe(response => {
        this.success = true;
        this.errors = null;
        this.service = new ServiceProvided(); // cleaning form 
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      })
  }
}
