import { Component, OnInit } from '@angular/core';

import { Client } from '../clients';
import { ClientsService } from 'src/app/clients.service';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  client: Client;

  constructor( private service: ClientsService) {
    //this.client = new Client();
    this.client = service.getClient();

  }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.client);
  }
}
