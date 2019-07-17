import React from "react";

import Logo from "../common/logo";
import ErrorExplanation from "./error-explanation";
import Input from "../common/input";
import Agreement from "./agreement";

import {
    validateEmail,
    validateNickname,
    passwordValidator,
    confirmPasswordValidator
} from "../../utills";
import Footer from "./footer";
import Button from "../common/button";


class Register extends React.Component {

    state = {
        errors: {
            nickname: null,
            email: null,
            password: null,
            confirmPassword: null
        }
    };

    componentWillMount() {
        this.validate();
    }

    errorsCount = () => {
        let count = 0;
        if (this.state.errors.nickname) count++;
        if (this.state.errors.email) count++;
        if (this.state.errors.password) count++;
        if (this.state.errors.confirmPassword) count++;
        return count;
    };

    toggleAgreement = () => {
        this.props.addUserRegisterData({
            ...this.props.data,
            agreement: !this.props.data.agreement
        });
    };

    setInputState = async (name, value) => {
        await this.props.addUserRegisterData({
            ...this.props.data,
            [name]: value
        });
        this.validate();
    };

    validate = () => {
        this.setState({
            errors: {
                email: validateEmail(this.props.data.email),
                nickname: validateNickname(this.props.data.nickname),
                password: passwordValidator(this.props.data.password),
                confirmPassword: confirmPasswordValidator(this.props.data.password, this.props.data.confirmPassword)
            }
        });
    };

    handleInputChange = e => {
        this.setInputState(
            e.target.name,
            e.target.value
        )
    };

    handleSubmit = e => {
        e.preventDefault();
        alert("submit");
    };


    render() {
        return (
            <div className='container-alt'>
                <Logo/>
                <div className='form-container' style={{"paddingTop": 0}}>
                    <form className="simple_form new_user" id="new_user" onSubmit={this.handleSubmit}>
                        {this.errorsCount() !== 0 && <ErrorExplanation count={this.errorsCount()}/>}
                        <div className='fields-group'>
                            <Input
                                name="nickname"
                                type="text"
                                handleInputChange={this.handleInputChange}
                                value={this.props.data.nickname}
                                error={this.state.errors.nickname}
                                label="Nickname"
                                hint="Your nickname will be unique on sonet.com"
                                maxLength={100}
                            />
                        </div>
                        <div className='fields-group'>
                            <Input
                                name="email"
                                type="email"
                                handleInputChange={this.handleInputChange}
                                value={this.props.data.email}
                                error={this.state.errors.email}
                                label="E-mail address"
                                hint="You will be sent a confirmation e-mail"
                            />
                        </div>
                        <div className='fields-group'>
                            <Input
                                name="password"
                                type="password"
                                handleInputChange={this.handleInputChange}
                                value={this.props.data.password}
                                error={this.state.errors.password}
                                label="Password"
                                hint="Use at least 8 characters"
                                maxLength={36}
                            />
                        </div>
                        <div className='fields-group'>
                            <Input
                                name="confirmPassword"
                                type="password"
                                handleInputChange={this.handleInputChange}
                                value={this.props.data.confirmPassword}
                                error={this.state.errors.confirmPassword}
                                label="Confirm password"
                                maxLength={36}
                            />
                        </div>
                        <div className='fields-group'>
                            <Agreement
                                agreement={this.props.data.agreement}
                                toggle={this.toggleAgreement}
                            />
                        </div>
                        <Button text="sing up"/>
                    </form>
                    <Footer/>
                </div>
            </div>
        )
    }
}

export default Register;