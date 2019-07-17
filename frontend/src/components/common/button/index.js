import React from "react";

const Button = props => {
    return (
        <div className='actions'>
            <button name="button" type="submit" className="btn">{props.text}</button>
        </div>
    );
};

export default Button;