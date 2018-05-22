import React, { Component } from 'react';
import '../css/App.css';
import axios from 'axios';
import FacebookLogin from 'react-facebook-login';

class Main extends Component {


    ping() {
        axios.get("http://localhost:8080/pong").then(res => {
            alert("Received Successful response from server!");
            this.setState({ponged: 'Ponged! '});
        }, err => {
            alert("Server rejected response with: " + err);
        });
    }
    constructor(props) {
        super(props);
        this.state = {ponged: 'Not Ponged'};

        this.ping = this.ping.bind(this);
    }

    render() {
        return (
            <div className="Main">
                <header className="App-header">
                    <h1 className="App-title">Ping</h1>
                </header>

                <div>
                    <FacebookLogin
                        appId="133588860742878"
                        autoLoad={true}
                        fields="name,email,picture"/>
                </div>
            </div>
        );
    }
}

export default Main;