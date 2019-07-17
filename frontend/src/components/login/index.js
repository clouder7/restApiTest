import React from "react";
import Logo from "../common/logo";
import ErrorExplanation from "../register/error-explanation";
import Input from "../common/input";
import Button from "../common/button";

class Login extends React.Component {

    state = {
        errors: {
            credentials: true
        }
    };

    handleSubmit = e => {
        e.preventDefault();
    };

    render() {
        return (
            <div className='container-alt'>
                <Logo/>
                <div className='form-container' style={{"paddingTop": 0}}>
                    <form className="simple_form new_user" id="new_user" onSubmit={this.handleSubmit}>
                        {this.state.errors.credentials && <ErrorExplanation count={1}/>}
                        <div className='fields-group'>
                            <Input
                                name="email"
                                type="email"
                                handleInputChange={this.handleInputChange}
                                value={this.props.email}
                                error={this.state.errors.credentials}
                                label="E-mail address"
                            />
                        </div>
                        <div className='fields-group'>
                            <Input
                                name="password"
                                type="password"
                                handleInputChange={this.handleInputChange}
                                value={this.props.password}
                                error={null}
                                label="Password"
                            />
                        </div>
                        <Button text="log in"/>
                    </form>
                </div>
            </div>
        );
    }

}

export default Login;