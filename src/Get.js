import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class Get extends Component {

  constructor(props){
    super(props);
    this.state = {product:{}};
  }

  onIdChange = (e)=>{
    this.setState({id:e.target.value});
  }

    getProduct(){
      const axios = require('axios');
      axios.get("http://localhost:8081/products/"+this.state.id)
      .then(res=>{
          console.log(res.data)
        this.setState({product:res.data});
      })
    }

    render() {
      return (
        <div>
          Enter Product ID:<input onChange={this.onIdChange}/>
          <button onClick={this.getProduct.bind(this)}>Get Product</button>
       <br/>
       Name: {this.state.product.name}
          <br/>
          Description: {this.state.product.description}
          <br/>
          Price: {this.state.product.price}
        
        </div>
      );
    }
  }

export default Get;
