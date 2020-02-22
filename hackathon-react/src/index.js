import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

import './Assets/css/bootstrap.min.css';
import './Assets/css/animate.css';
import './Assets/css/flaticon.css';
import './Assets/css/font-awesome.min.css';
import './Assets/css/gijgo.css';
import './Assets/css/jquery-ui.css';
import './Assets/css/magnific-popup.css';
import './Assets/css/nice-select.css';
// import './Assets/css/owl.carousel.min.css';
import './Assets/css/slick.css';
import './Assets/css/slicknav.css';
import './Assets/css/style.css';
import './Assets/css/theme-default.css';
import './Assets/css/themify-icons.css';

ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
