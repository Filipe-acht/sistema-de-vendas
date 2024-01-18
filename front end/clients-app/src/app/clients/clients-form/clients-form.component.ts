import { Component, OnInit } from '@angular/core';

import { Client } from '../client';
import { ClientsService } from 'src/app/clients.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  client: Client;
  success: boolean = false;
  errors: String[];
  id: number;
  constructor(
    private service: ClientsService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.client = new Client();
  }

  ngOnInit(): void {
    let params: Observable<Params> = this.activatedRoute.params;
    params.subscribe(urlsParams => {
      this.id = urlsParams['id'];
      if (this.id) {
        this.service
          .getClientById(this.id)
          .subscribe(
            response => this.client = response,
            errorResponse => this.client = new Client()
          )
      }
    })
  }

  onSubmit() {
    if (this.id) {

      this.service
        .update(this.client)
        .subscribe(response => {
          this.success = true;
          this.errors = null;
        }, errorResponse => {
          this.success = false;
          this.errors = ['Updating client failed!']
        })
    } else {

      this.service
        .save(this.client)
        .subscribe(response => {
          this.success = true;
          this.errors = null;
          this.client = response;
        }, errorResponse => {
          this.success = false;
          this.errors = errorResponse.error.errors;
        })
    }

  }

  backToList() {
    this.router.navigate(['/clients-list']);
  }
}
