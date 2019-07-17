import React, {Component} from "react";
import {Redirect} from "react-router-dom";

import "./Login.css";

class Login extends Component {

    state = {
        redirect: false
    };

    handleInputChange(e) {
        this.setInputState(
            e.target.name,
            e.target.value
        )
    };

    setInputState = (name, value) => {
        this.props.addUserRegisterData({
            ...this.props.data,
            [name]: value
        });
    };

    handleSubmit = e => {
        e.preventDefault();
        this.setState({
            redirect: true
        });
    };

    render() {
        if (this.state.redirect) {
            return <Redirect push to="/auth/login"/>
        }
        return (
            <form className="simple_form new_user"
                  id="new_user"
                  noValidate="novalidate"
                  action="/auth/sign_in"
                  onSubmit={this.handleSubmit}
                  method="post">
                <div className='fields-group'>
                    <div className="input email optional user_email">
                        <input aria-label="E-mail address"
                               className="string email optional"
                               placeholder="E-mail address"
                               type="email"
                               name="user[email]"
                               id="user_email"/>
                    </div>
                    <div className="input password optional user_password">
                        <input aria-label="Password"
                               className="password optional"
                               placeholder="Password"
                               type="password"
                               name="user[password]"
                               id="user_password"/>
                    </div>
                </div>
                <div className='actions'>
                    <button name="button" type="submit"
                            className="btn button button-primary">Log in
                    </button>
                </div>
                <p className='hint subtle-hint'><a href="/auth/password/new">Trouble logging
                    in?</a></p>
            </form>
        );
    }
}

export default Login;