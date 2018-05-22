import React, { Component } from 'react';
import {Redirect} from 'react-router-dom';
import '../css/App.css';
import axios from 'axios';
import FacebookLogin from 'react-facebook-login';

class Main extends Component {

    signup(res, type) {
        let postData;
        if (type === 'facebook' && res.email) {
            postData = {
                name: res.name,
                provider: type,
                email: res.email,
                provider_id: res.id,
                token: res.accessToken,
                provider_pic: res.picture.data.url
            };
        }


    }

   responseFacebook  (response)  {
            console.log("facebook console");
            console.log(response);
            this.signup(response, 'facebook');
    }


    ping() {
        axios.get("http://localhost:8080/pong").then(res => {
            alert("Received Successful response from server!");
            this.setState({ponged: res.data});
        }, err => {
            alert("Server rejected response with: " + err);
        });
    }

    constructor(props) {
        super(props);

        super(props);
        this.state = {
            loginError: false,
            redirect: false,
            ponged: 'Not Ponged'
        };
        this.signup = this.signup.bind(this);
        this.ping = this.ping.bind(this);
    }

    render() {
        return (
            <div className="Main">
                <header className="App-header">
                    <h1 className="App-title">Ping</h1>
                </header>
                <p className="App-intro">
                    <div>
                        <button onClick={this.ping}>Ping!</button>
                        <div>Ponged: {this.state.ponged}</div>
                    </div>
                </p>

                <div>
                    <FacebookLogin
                        appId="133588860742878"
                        autoLoad={true}
                        fields="name,email,picture"
                        callback={this.responseFacebook}/>
                </div>owan
            </div>
        );
    }
}

export default Main;