import React, {Component} from 'react';
import {BrowserRouter, Route, Link, Redirect} from "react-router-dom";

import About from "./components/about/About";
import Register from "./components/register/RegisterContainer";
import Login from "./components/login/LoginContainer";

import {Provider} from "react-redux";
import store from "./store";

import "./App.css";

class App extends Component {

    render() {
        return (
            <Provider store={store}>
                <BrowserRouter>
                    <Route exact path="/about" component={About}/>
                    <Route exact path="/auth" component={Register}/>
                    <Route exact path="/auth/login" component={Login}/>
                    <Redirect from="/" to="/about"/>
                </BrowserRouter>
            </Provider>
        );
    }

}

export default App;