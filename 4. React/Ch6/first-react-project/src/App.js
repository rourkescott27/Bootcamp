import React, { Component } from 'react';
// import { Button } from 'react-bootstrap';
// import Products from './Products';
// import Rating from './Rating';
// import JumboTronComponent from './JumboTronComponent';
// import { Formik } from 'formik';
import UserForm from './UserForm';

class App extends Component {
  render() {
    return (
      <div>
         <UserForm/>
        {/* <Products />
        <JumboTronComponent>
          This is a long sentence, and I want to insert content into the
          jumbotron component from the outside.
        </JumboTronComponent> */}
        {/* <Rating rating="1" />
        <Rating rating="2" />
        <Rating rating="3" />
        <Rating rating="4" />
        <Rating rating="5" />
        <Button variant='primary' disabled={!isValid}>Click Here</Button> */}
      </div>
    );
  }
}

export default App;
