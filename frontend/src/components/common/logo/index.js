import React from "react";

const Logo = props => {
    return (
        <div className='logo-container'>
            <h1>
                <a href="/">
                    <img src="/img/logo.png" style={{width: "350px", heigth: "50px"}} alt=""/>
                </a>
            </h1>
        </div>
    );
}

export default Logo;