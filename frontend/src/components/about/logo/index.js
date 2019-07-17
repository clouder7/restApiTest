import React from "react";

const Logo = () => {
    return (
        <div className='landing__brand'>
            <a className="brand" href="https://sonet.org/">
                <img src="/img/logo.png" style={{width: "350px", heigth: "50px"}} alt=""/>
            </a>
        </div>
    );
};

export default Logo;