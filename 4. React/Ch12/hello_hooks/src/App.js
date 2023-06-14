import React, { useState } from 'react';
import useFetch from './useFetch';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'react-bootstrap';
import Users from './users';

const App = () => {

  const postsUrl = "https://jsonplaceholder.typicode.com/posts";
  const todosUrl = "https://jsonplaceholder.typicode.com/todos";

  const [requested, setRequested] = useState('posts');
  const data = useFetch(requested);

  return (
    <div>
      <Users/>
      <Button variant='link' onClick={() => setRequested(postsUrl)}>
        Posts
      </Button>
      <Button variant='link' onClick={() => setRequested(todosUrl)}>
        To do's
      </Button>
      <br />
      Requested: {requested}
      <ul>
        {data.map(el => (
          <li key={el.id}>{el.title}</li>
        ))}
      </ul>
    </div>
  )
}

export default App;
