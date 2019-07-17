import React from "react";

const GalaxyChat = () => {
    return (
        <a href="/explore">
            <h4>
                <i className="fa fa-address-book fa-fw"> </i>
                Galaxy
                chat
                <small> Tr
                    intergalactic
                    chat :)
                </small>
            </h4>
            <div className='avatar-stack'>
                <img width="48" height="48" alt="" className="account__avatar" src=""/>
                <img width="48" height="48" alt="" className="account__avatar" src=""/>
                <img width="48" height="48" alt="" className="account__avatar" src=""/>
                <img width="48" height="48" alt="" className="account__avatar" src=""/>
            </div>
        </a>
    );
};

export default GalaxyChat;