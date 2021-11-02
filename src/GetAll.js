import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Create from "./Create";
import Get from "./Get";

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
        <Create></Create>
        <Get></Get>
        <h1>Products:</h1>
        <hr></hr>
        <table class="table table-dark">
          <th scope="col">Product ID</th>
          <th>Product Name</th>
          <th>Description</th>
          <th>Product Price</th>
          {this.state.products.map(product => <tr><td>{product.id}</td> <td> {product.name}</td> <td>{product.description}</td> <td>{product.price}</td></tr>)}
          </table>
        </div>
    );
  }
}

export default GetAll;
