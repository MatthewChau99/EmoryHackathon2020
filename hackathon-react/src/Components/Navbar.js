import React, {Component} from 'react';
import logo from '../Assets/img/logo1.png';
import {Link} from "react-router-dom";

class Navbar extends Component {
    render() {
        const logoLink = <li><Link to='/'><img src={logo} alt=""/></Link></li>;
        return (
            <header>
                <div className="header-area ">
                    <div id="sticky-header" className="main-header-area">
                        <div className="container-fluid p-0">
                            <div className="row align-items-center no-gutters">
                                <div className="col-xl-2 col-lg-2">
                                    <div className="logo">
                                        {logoLink}
                                    </div>
                                </div>
                                <div className="col-xl-6 col-lg-6">
                                    <div className="main-menu  d-none d-lg-block">
                                        <nav>
                                            <ul id="navigation">
                                                {/*<li><a className="active" href="index.html">home</a></li>*/}
                                                {/*<li><a href="about.html">About</a></li>*/}
                                                {/*<li><a href="menu.html">Menu</a></li>*/}
                                            </ul>
                                        </nav>
                                    </div>
                                </div>

                                <div className="col-xl-4 col-lg-4 d-none d-lg-block">
                                    <div className="social_wrap d-flex align-items-center justify-content-end">
                                        <div className="login_text">
                                            <a href="login.html">Login</a>
                                        </div>
                                        <div className="number">
                                            <p>Our <a href="https://www.instagram.com/"> Instagram</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-12">
                                    <div className="mobile_menu d-block d-lg-none"/>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </header>
        );
    }
}

export default Navbar;