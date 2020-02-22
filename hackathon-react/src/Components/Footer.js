import React, {Component} from 'react';

class Footer extends Component {
    render() {
        return (
            <footer className="footer footer_bg_1">
                <div className="footer_top">
                    <div className="container">
                        <div className="row">
                            <div className="col-xl-3 col-md-6 col-lg-3">
                                <div className="footer_widget ">
                                    <h3 className="footer_title">
                                        Mission Statement
                                    </h3>
                                    <p>Make every swipe worth it Track your favorite dishes Push daily notification </p>
                                    <div className="footer_logo">
                                        <a href="#">
                                            <img src="logo1.png" alt=""/>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div className="col-xl-3 col-md-6 col-lg-3">
                                <div className="footer_widget ">
                                    <h3 className="footer_title">
                                        Contact Info
                                    </h3>
                                    <p>Address: 201 Dowman Dr, Atlanta, GA 30322 Emory University</p>
                                    <ul>
                                        <li><a href="#">Phone : +1 4704557899</a></li>
                                        <li><a href="#">Email : track-duc@emory.edu</a></li>
                                    </ul>

                                </div>
                            </div>
                            <div className="col-xl-3 col-md-6 col-lg-3">
                                <div className="footer_widget ">
                                    <h3 className="footer_title">
                                        Important Link
                                    </h3>
                                    <ul>
                                        <li><a href="menu.html">View Menu</a></li>
                                        <li><a href="#">Contact Us</a></li>
                                        <li><a href="#">Join our email list</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div className="col-xl-3 col-md-6 col-lg-3">
                                <div className="footer_widget">
                                    <h3 className="footer_title">
                                        Join our email list
                                    </h3>
                                    <p className="newsletter_text">
                                        Receive daily cafeteria menu with highlighted dishes
                                    </p>
                                    <form action="#" className="newsletter_form">
                                        <input type="text" placeholder="Enter your mail"/>
                                            {/*<button type="submit"><i className="fa fa-paper-plane"/></button>*/}
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="copy-right_text">
                    <div className="container">
                        <div className="footer_border"/>
                        <div className="row">
                            <div className="col-lg-4">
                                <div className="social_links">
                                    <ul>
                                        <li>
                                            <a href="#">
                                                <i className="ti-facebook"/>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i className="fa fa-twitter"/>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i className="fa fa-dribbble"/>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i className="fa fa-behance"/>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        );
    }
}

export default Footer;