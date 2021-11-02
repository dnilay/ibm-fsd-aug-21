import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class Delete extends Component {

    constructor(props){
        super(props);
        this.state = {product:{}};
    }

    onIdChange = (e)=>{
        this.setState({id:e.target.value});
    }

    deleteProduct(){
        const axios = require('axios');
        axios.delete("http://localhost:8081/products/"+this.state.id)
            .then(res=>{
                console.log(res.data)
               this.setState({product:res.data});
            })
    }

    render() {
        return (
            <div>
                Enter Product ID:<input onChange={this.onIdChange}/>
                <button onClick={this.deleteProduct.bind(this)}>Delete Product</button>

            </div>
        );
    }
}

export default Delete;
