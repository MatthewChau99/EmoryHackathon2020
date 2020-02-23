import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class MainPage extends Component {
    render() {
        return (
            <div className="slider_area">
                <div className="slider_active owl-carousel">
                    <div className="single_slider  d-flex align-items-center slider_bg_1 overlay">
                        <div className="container">
                            <div className="row align-items-center">
                                <div className="col-xl-6 col-md-8">
                                    <div className="slider_text">
                                        <h3>We Offer You
                                            A Better
                                            Dinning Experience</h3>
                                        <p>Sign up and put down your favorite dishes.
                                            Receive immediate notification when DCT offers on that day </p>
                                        <a className="boxed-btn3">
                                            <Link to='Menu'>
                                                <p>
                                                    View Today's Menu
                                                </p>
                                            </Link>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default MainPage;