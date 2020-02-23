import React from 'react';
import './App.css';
import MainPage from './Containers/MainPageContainer';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Navbar from "./Components/Navbar";
import Footer from "./Components/Footer";
import MenuContainer from "./Containers/MenuContainer";
import {Provider} from "react-redux";
import store from "./store";

function App() {
  return (
      <Provider store={store}>
          <Router>
              <Navbar/>
              <Route exact={true} path='/' component={MainPage}/>
              <Route exact={true} path='/Menu' component={MenuContainer}/>
              <Footer/>
          </Router>
      </Provider>

  );
}

export default App;
