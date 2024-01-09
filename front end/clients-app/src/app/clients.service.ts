import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Client } from './clients/clients';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http: HttpClient) { }

  getClient(): Client {
    let client: Client = new Client();
    client.name = 'Fulano';
    client.cpf = '888';
    return client;
  }
}
