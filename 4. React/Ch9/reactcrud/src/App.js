import React, { Component } from 'react';
import './App.css';
import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import 'firebase/compat/firestore';
import 'firebase/compat/database';
import User from './User';
import UserForm from './UserForm';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {

  constructor() {
    super();
    console.log(firebase);
  }

  render() {
    return (
      <div>
        <BrowserRouter>
          <div>
            <Routes>
              <Route exact path="/edit/:id" element={<UserForm />} />
              <Route exact path="/add" element={<UserForm />} />
              <Route exact path="/" element={<User />} />
              <Route path="/*" element={<NotFound />} />
            </Routes>
          </div>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;

class NotFound extends Component {
  render() {
    return <h1>**404 ERROR Page Not Found**</h1>
  }
}
