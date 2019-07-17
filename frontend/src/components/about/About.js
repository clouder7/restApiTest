import React from "react";

import Register from './registerForm/RegisterFormContainer';
import Login from './login/Login';
import Post from './post/Post';
import Footer from './footer/Footer';
import GalaxyChat from "./galaxy-chat";
import Logo from "../common/logo";

class About extends React.Component {
    render() {
        return (
            <div className="stars">
                <div className="twinkling">
                    <div className='public-layout'>
                        <div className='container'>
                            <div className='landing'>
                                <Logo/>
                                <div className='landing__grid'>
                                    <div className='landing__grid__column landing__grid__column-registration'>
                                        <div className='box-widget'>
                                            <Register/>
                                        </div>
                                        <div className='directory'>
                                            <div className='directory__tag'>
                                                <GalaxyChat/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className='landing__grid__column landing__grid__column-login'>
                                        <div className='box-widget'>
                                            <Login/>
                                        </div>
                                        <Post/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className='container'>
                            <Footer/>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default About;