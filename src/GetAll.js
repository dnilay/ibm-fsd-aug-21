import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class GetAll extends Component {

  constructor(props){
    super(props);
    this.state = {products:[]};
  }

  componentDidMount(){
    const axios = require('axios');
    axios.get('http://localhost:8081/products/')
    .then(res=>{
      console.log(res.data)
      this.setState({products:res.data});
    }).catch(error=>{
      console.error('Error',error)
    })
  }

  render() {
    return (
      <div>
        <h1>Products:</h1>
        {this.state.products.map(product => <div>{product.id} {product.name} {product.description} {product.price}</div>)}
      </div>
    );
  }
}

export default GetAll;
