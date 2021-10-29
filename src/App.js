import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  handleClick(event){
    const axios = require('axios');
    alert(event.target.value)

    axios.get('http://localhost:8082/customers')
    .then(res=>{
      console.log(res.data);
    }).catch(error=>{
      console.error('Error',error)
    })
  }


  
  render() {
    return (
      <div className="App">
       <button onClick={this.handleClick.bind(this)} name="mybutton" value="test">Get Customers</button>
      </div>
    );
  }
}

export default App;
