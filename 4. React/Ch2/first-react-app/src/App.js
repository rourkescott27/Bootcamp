import React, { Component } from 'react';
import Products from './Products';

class App extends Component {
  formatName(user) {
    return user.firstName + " " + user.lastName;
  }
  render() {
    const user = {
      firstName: 'Gregory',
      lastName: 'Lim'
    }
    return (
      <div>
        <h1>Hello {this.formatName(user)}, here is your list.</h1>
        <Products />
      </div>
    );
  }
}

export default App;
