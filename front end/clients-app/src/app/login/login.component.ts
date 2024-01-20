import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './user';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  signUp: boolean;
  successMessage: string;
  errors: String[];

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  onSubmit() {
    this.authService
      .trySignIn(this.username, this.password)
      .subscribe(response => {
        const access_token = JSON.stringify(response);
        localStorage.setItem('access_token', access_token);
        this.router.navigate(['/home'])
      }, errorResponse => {
        this.errors = ['User and/or password is invalid!']
      })
  }

  preparingRegister(event) {
    event.preventDefault();
    this.signUp = true;
  }

  cancelRegister() {
    this.signUp = false;
  }

  registerUser() {
    const user: User = new User();
    user.username = this.username;
    user.password = this.password;
    this.authService
      .save(user)
      .subscribe(response => {
        this.successMessage = "Register successfully did! Try login now.";
        this.signUp = false;
        this.username = '';
        this.password = '';
        this.errors = []
      }, errorResponse => {
        this.successMessage = null;
        this.errors = errorResponse.error.errors;
      })
  }
}
