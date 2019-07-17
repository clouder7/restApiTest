import React from "react";
import classNames from "classnames";
import PropTypes from 'prop-types';
import {default as UUID} from "uuid";

class Input extends React.Component {

    componentWillMount() {
        this.id = UUID.v4();
    }

    render() {
        return (
            <div className={classNames(
                "input with_label", "string", "required", {"field_with_hint": this.props.hint}, {"field_with_errors": this.props.error})}>
                <div className="label_input">
                    <label className="string required">
                        {this.props.label}
                        <abbr title="required">*</abbr>
                    </label>
                    <div className="label_input__wrapper">
                        <input aria-label="Username"
                               autoComplete="off"
                               className="string required"
                               autoFocus="autofocus"
                               required="required"
                               aria-required="true"
                               type={this.props.type}
                               value={this.props.value}
                               onChange={ this.props.handleInputChange}
                               name={this.props.name}
                               maxLength={this.maxLength}
                        />
                    </div>

                </div>
                {this.props.hint != null && <span className="hint">{this.props.hint}</span>}
                {this.props.error != null && <span className="error">{this.props.error}</span>}
            </div>
        );
    }
}

Input.defaultProps = {
    hint: null,
    type: "text",
    maxLength:10000
};

Input.propTypes = {
    hint: PropTypes.string,
    error: PropTypes.oneOfType([
        PropTypes.string.isRequired,
        PropTypes.oneOf([null]).isRequired
    ]),
    value: PropTypes.oneOfType([
        PropTypes.string.isRequired,
        PropTypes.oneOf([null]).isRequired
    ]),
    type: PropTypes.string.isRequired,
    name: PropTypes.string.isRequired,
    handleInputChange: PropTypes.func.isRequired,
    label: PropTypes.string.isRequired
};

export default Input;