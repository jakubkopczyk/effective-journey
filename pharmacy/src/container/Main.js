import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Nfz from './Nfz';


import '../css/App.css';

class Main extends Component {
  render() {
    return (
      <div className="Main">
      <div id="kontener">
      <div id="naglowek"></div>
      <div id="menu">
      <Link to="/">Strona Główna</Link>
      <Link to="/bezrecepty">Leki bez recepty</Link>
      <Link to="/narecepte">Leki na repectę</Link>
      </div>

      <div id="tytul">
            <h3>Apteka</h3>
      </div>
      <div id="tresc">
            <h2>Witamy na stronie Apteki</h2>
            <Nfz />
      </div>



      <div id="stopka">
      <div id="copyright">Copyright by </div>
      <div id="design"></div>
      </div>
      </div>
    </div>
    );
  }
}

export default Main;
