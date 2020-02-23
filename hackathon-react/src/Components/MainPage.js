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
                                <div className="col-xl-10 col-md-8">
                                    <div className="slider_text">
                                        <h3>We Offer You
                                            A Better
                                            Dinning Experience</h3>
                                        <p>Sign up and put down your favorite dishes.
                                            Receive immediate notification when DCT offers on that day </p>
                                        <Link to='/Menu'>
                                            <a href="" class ="boxed-btn3">
                                                View Today's Menu
                                            </a>
                                        </Link>
                                        <a href="https://emorycollege.co1.qualtrics.com/jfe/form/SV_40WnvR34mNeXCRf" className="boxed-btn3">
                                            Rate  Your  Meal
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