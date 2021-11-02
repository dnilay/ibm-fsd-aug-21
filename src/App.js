import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {Route, Switch, Link, Redirect} from "react-router-dom";
import GetAll from "./GetAll";
import Create from "./Create";
import Get from "./Get";
import Update from "./Update";

class App extends Component {
    render() {
        return (
            <div className="App">
                <nav className="navbar navbar-expand-lg navbar-light bg-light" >

                    <div className="collapse navbar-collapse" id="navbarText">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <a className="nav-link" href="/">Home</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="Create">Create </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="Get">Get</a>

                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="Update">Update</a>

                            </li>
                        </ul>

                    </div>
                </nav>


                <Switch>
                    <Route exact path="/" component={GetAll}/>
                    <Route path="/Create" component={Create}/>
                    <Route path="/Get" component={Get}/>

                    <Route path="/Update" component={Update}/>

                </Switch>


            </div>
        );
    }
}

export default App;