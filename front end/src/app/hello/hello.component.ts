import { Component } from '@angular/core'

@Component({
  selector: 'hello', // vai ser referenciado com uma tag html <hello></hello>
  templateUrl: './hello.component.html'
  /*template: `
    <h1>Hello World!</h1>
  `*/
})
//export torna a class publica
export class HelloComponent {

  //nome : string = 'Filipe';
  name: string;
  clients: Client[];
  constructor() {
    this.name = 'Filipe';
    let client1 = new Client('Filipe', 23);
    let client2 = new Client('Emily', 23);
    let client3 = new Client('Lily', 3);

    this.clients = [client1, client2, client3];
  }
}
class Client {

  constructor(
    public name: string,
    public age: number
  ){}
}
