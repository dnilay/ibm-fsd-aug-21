import React from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

class DisplayFlights extends React.Component{
    state ={
        flightData:[]
    }

    componentWillMount(){
        axios.get('http://localhost:8082/flights/').then(res=>{
            const flightData = res.data;
            this.setState({flightData})
            console.log(flightData)
        })
    }

    render(){
        return (<div>
            <h2>Flights:</h2>
            <table class="table table-dark">
                <thead>
                    <th scope="col">Airlines</th>
                    <th scope="col">Departure City</th>
                    <th scope="col">Arrival City</th>
                    <th scope="col">Departure Date and Time</th>
                </thead>
                <tbody>
                    {this.state.flightData.map(flight=><RowCreator item={flight}/>)}
                </tbody>
            </table>
        </div>)
    }
}

class RowCreator extends React.Component{
    render(){
        var flight = this.props.item;
        return <tr>
            <td>{flight.operatingAirlines}</td>
            <td>{flight.departureCity}</td>
            <td>{flight.arrivalCity}</td>
            <td>{flight.estimatedDepartureTime}</td>
            <td><Link to={'/passengerDetails/'+flight.id}>Select</Link></td>
        </tr>
    }
}













export default DisplayFlights;