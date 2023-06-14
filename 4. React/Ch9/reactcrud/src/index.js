import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import 'firebase/compat/firestore';

const firebaseConfig = {
  apiKey: "AIzaSyCEEI_G8Wqa0td7VQF7c5J-eGIBKeZrm1g",
  authDomain: "crudproject-7ff16.firebaseapp.com",
  projectId: "crudproject-7ff16",
  storageBucket: "crudproject-7ff16.appspot.com",
  messagingSenderId: "394069800129",
  appId: "1:394069800129:web:126d349ab0b44ba1341040",
  measurementId: "G-1YS5R5CRSR"
};
firebase.initializeApp(firebaseConfig);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
