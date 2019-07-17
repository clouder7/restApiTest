import React, {Component} from "react";
import {Redirect} from "react-router-dom";

class RegisterForm extends Component {

    state = {
        redirectToRegister: false,
    };

    toggleAgreement = () => {
       this.props.addUserRegisterData({
            ...Object.assign({},this.props.data),
            agreement: !this.props.data.agreement
        });
    };

    setInputState = (name, value) => {
        this.props.addUserRegisterData({
            ...this.props.data,
            [name]: value
        });
    };

    handleInputChange(e) {
        this.setInputState(
            e.target.name,
            e.target.value
        )
    }

    handleSubmit(e) {
        e.preventDefault();
        this.setState({
            redirectToRegister: true
        });
    }

    render() {
        if (this.state.redirectToRegister) {
            return <Redirect push to="/auth"/>
        }
        return (
            <form
                className="simple_form new_user"
                id="new_user"
                noValidate="novalidate"
                action="/authFormAction"
                acceptCharset="UTF-8"
                method="post"
                onSubmit={(e) => this.handleSubmit(e)}
            >
                <input name="utf8" type="hidden"/>
                <input
                    type="hidden"
                    name="authenticity_token"
                />
                <div className="simple_form__overlay-area">
                    <p className="lead">
                        With an account on <strong>sonet.org</strong> you'll be able to
                        follow people on any Sonet server and beyond.
                    </p>
                    <div className="fields-group">
                        <div className="input with_label string required user_account_username">
                            <div className="label_input">
                                <div className="label_input__wrapper">
                                    <input
                                        aria-label="Username"
                                        autoComplete="off"
                                        placeholder="Username"
                                        className="string required"
                                        required="required"
                                        aria-required="true"
                                        type="text"
                                        name="nickname"
                                        id="user_account_attributes_username"
                                        value={this.props.data.nickname}
                                        onChange={(e) => this.handleInputChange(e)}
                                    />
                                    <div className="label_input__append">@sonet.org</div>
                                </div>
                            </div>
                        </div>
                        <div className="input email required user_email">
                            <input
                                aria-label="E-mail address"
                                autoComplete="off"
                                className="string email required"
                                required="required"
                                aria-required="true"
                                placeholder="E-mail address"
                                type="email"
                                name="email"
                                id="user_email"
                                value={this.props.data.email}
                                onChange={(e) => this.handleInputChange(e)}
                            />
                        </div>
                        <div className="input password required user_password">
                            <input
                                aria-label="Password"
                                autoComplete="off"
                                className="password required"
                                required="required"
                                aria-required="true"
                                placeholder="Password"
                                type="password"
                                name="password"
                                id="user_password"
                                value={this.props.data.password}
                                onChange={(e) => this.handleInputChange(e)}
                            />
                        </div>
                        <div className="input password required user_password_confirmation">
                            <input
                                aria-label="Confirm password"
                                autoComplete="off"
                                className="password required"
                                required="required"
                                aria-required="true"
                                placeholder="Confirm password"
                                type="password"
                                name="confirmPassword"
                                id="user_password_confirmation"
                                value={this.props.data.confirmPassword}
                                onChange={(e) => this.handleInputChange(e)}
                            />
                        </div>
                    </div>
                    <div className="fields-group">
                        <div className="input with_label boolean optional user_agreement">
                            <div className="label_input">
                                <label className="boolean optional" htmlFor="user_agreement">
                                    I agree to the{" "}
                                    <a href="/about/more" target="_blank">
                                        server rules
                                    </a>{" "}user_agreement
                                    and{" "}
                                    <a href="/terms" target="_blank">
                                        terms of service
                                    </a>
                                </label>
                                <div className="label_input__wrapper">
                                    <input
                                        type="hidden"
                                        name="agreement"
                                    />
                                    <label className="checkbox">
                                        <input
                                            className="boolean optional"
                                            type="checkbox"
                                            name="agreement"
                                            id="user_agreement"
                                            checked={this.props.data.agreement}
                                            onChange={(e) => this.toggleAgreement()}
                                        />
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="actions">
                        <button
                            type="submit"
                            className="btn button button-primary"
                        >
                            Sign up
                        </button>
                    </div>
                </div>
            </form>
        );
    }
}

export default RegisterForm;
