import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  loginError: boolean;
  signUp: boolean;

  constructor(
    private router: Router
  ) { }

  onSubmit() {

    this.router.navigate(['/home'])
  }

  preparingRegister(event) {
    event.preventDefault();
    this.signUp = true;
  }

  cancelRegister() {
    this.signUp = false;
  }

}
