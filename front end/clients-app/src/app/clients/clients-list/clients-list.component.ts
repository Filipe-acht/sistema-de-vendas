import { Component, OnInit } from '@angular/core';
import { Client } from '../clients';
import { ClientsService } from '../../clients.service';


@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {

  clients: Client[] = [];

  constructor(private service: ClientsService) { }

  ngOnInit(): void {
    this.service
      .getClients()
      .subscribe( resposta => this.clients = resposta );
  }

}
