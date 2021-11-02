import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {Route,Switch,Link} from "react-router-dom";
import GetAll from "./GetAll";
import Create from "./Create";


class App extends Component {
    render() {
        return (
            <div className="App">


                <GetAll></GetAll>
            </div>
        );
    }
}

export default App;