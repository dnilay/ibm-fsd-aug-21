import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {Route,Switch} from 'react-router-dom';
import DisplayFlights from "./components/DisplayFlights";


class App extends Component {
  render() {
    return (
      <div className="App">
       <Switch>
        <Route exact path="/" component={DisplayFlights}/>

       </Switch>
      </div>
    );
  }
}

export default App;
