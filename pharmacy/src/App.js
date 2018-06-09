  import React, { Component } from 'react';
  import {
    BrowserRouter as Router,
    Route,
    Link
  } from 'react-router-dom';

  import BezRecepty from './container/BezRecepty';
  import NaRecepte from './container/NaRecepte';
  import Main from './container/Main';
  import './css/App.css';
  import './css/style.css';


  class App extends Component {

    render() {
      return (
        <Router>
          <div className="container">
            <Route exact path="/" component={Main} />
            <Route path="/bezrecepty" component={BezRecepty} />
            <Route path="/narecepte" component={NaRecepte} />
          </div>
        </Router>
      );
    }
  }

  export default App;
