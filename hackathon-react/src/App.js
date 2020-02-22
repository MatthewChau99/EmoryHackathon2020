import React from 'react';
import logo from './logo.svg';
import './App.css';
// import './Assets/css/style.css';
import Navbar from "./Components/Navbar";
import MainPage from "./Components/MainPage";
import Footer from "./Components/Footer";

function App() {
  return (
      <div className="App">
          <Navbar/>
          <MainPage/>
          <Footer/>
      </div>

  );
}

export default App;
