import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../node_modules/bootstrap-icons/font/bootstrap-icons.css";
import React from "react"
import WeatherApp from "./weather/WeatherApp";
import './App.css';


class App extends React.Component {
  render() {
    return (
      <div>
        <WeatherApp />
      </div>
    );
  }
}

export default App;

