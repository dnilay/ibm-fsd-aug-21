import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class Create extends Component {

  constructor(props){
    super(props);
    this.state = {product:{}};
  }

  onIdChange = (e)=>{
    this.setState({id:e.target.value});
  }

  onNameChange = (e)=>{
    this.setState({name:e.target.value});
  }
  onDescriptionChange = (e)=>{
    this.setState({description:e.target.value});
  }
  onPriceChange = (e)=>{
    this.setState({price:e.target.value});
  }

  createProduct(event){
    const axios = require('axios');
    axios.post('http://localhost:8081/products/',{id:this.state.id,name:this.state.name,
              description:this.state.description,
              price:this.state.price})
              .then(res=>{
                    console.log(res.data);
                  window.location.reload(false);
                })

  }

  render() {
    return (
        <div>
      <div class="form-group">
          PRODUCT ID<input  class= "form-control form-control-sm" onChange={this.onIdChange}/>
      </div>
        <div class="form-group">
          PRODUCT NAME<input class="form-control form-control-sm" onChange={this.onNameChange}/>
        </div>
      <div class="form-group">
            PRODUCT DESCRIPTIONS<input  class="form-control form-control-sm" onChange={this.onDescriptionChange}/>
      </div>
      <div class="form-group">
          PRODUCT PRICE<input class="form-control form-control-sm" onChange={this.onPriceChange}/>
      </div>
      <div class="form-group form-control-sm">
          <button class="btn btn-primary" onClick={this.createProduct.bind(this)} >Create Product</button>
      </div>
      </div>
    );
  }
}

export default Create;
