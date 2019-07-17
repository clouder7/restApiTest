import React, {Component} from "react";

class Post extends Component {
    render() {
        return (
            <div className='hero-widget'>
                <div className='hero-widget__img'>
                    {/* For image */}
                </div>
                <div className='hero-widget__text'>
                    <p>
                       Post text
                    </p>
                </div>
                <div className='hero-widget__footer'>
                    <div className='hero-widget__footer__column'>
                        <h4>Our Text:</h4>
                        <div className="account">
                            <div className="account__wrapper"><a className="account__display-name"
                                                                 href="https://fosstodon.org/@fosstodon">
                                <div className="account__avatar-wrapper">
                                </div>
                                <span className="display-name"><bdi><strong
                                    className="display-name__html emojify">Our Text</strong></bdi><span
                                    className="display-name__account">@sonet</span></span></a>
                            </div>
                        </div>
                    </div>
                    <div className='hero-widget__footer__column'>
                        <h4>Server stats:</h4>
                        <div style={{'display': 'flex'}}>
                            <div className='hero-widget__counter' style={{'width': '50%'}}>
                                <strong>1000k</strong>
                                <span>users</span>
                            </div>
                            <div className='hero-widget__counter' style={{'width': '50%'}}>
                                <strong>1000k</strong>
                                <span>
active
<abbr title='Monthly Active Users (MAU)'>*</abbr>
</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Post;