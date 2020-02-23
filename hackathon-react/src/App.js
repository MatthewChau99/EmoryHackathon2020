import React from 'react';
import './App.css';
import MainPageContainer from './Containers/MainPageContainer';
import MenuContainer from "./Containers/MenuContainer";
import RateContainer from "./Containers/RateContainer";
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Navbar from "./Components/Navbar";
import Footer from "./Components/Footer";

import {Provider} from "react-redux";
import store from "./store";

function App() {
  return (
      <Provider store={store}>
          <Router>
              <Navbar/>
              <Route exact={true} path='/' component={MainPageContainer}/>
              <Route exact={true} path='/Menu' component={MenuContainer}/>
              <Route exact={true} path='/Rate' component={RateContainer}/>

              <Footer/>
          </Router>
      </Provider>

  );
}

export default App;
