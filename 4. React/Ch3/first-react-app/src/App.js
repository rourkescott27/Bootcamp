import React, { Component } from 'react';
import { Button } from 'react-bootstrap';
import Rating from './Rating';

class App extends Component {
  render() {
    const isValid = false;
    return (
      <div>
        <Rating rating="1" />
        <Rating rating="2" />
        <Rating rating="3" />
        <Rating rating="4" />
        <Rating rating="5" />
        <Button variant='primary' disabled={!isValid}>Click Here</Button>
      </div>
    );
  }
}

export default App;
