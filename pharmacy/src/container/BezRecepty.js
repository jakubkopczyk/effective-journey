import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

class BezRecepty extends Component{
  constructor(props) {
    super(props);
    this.state = {
      lista_bez_recepty: [],
      isLoading: false
    };
  }

  render() {
    const {isLoading} = this.state;

    if (isLoading) {
        return <p>Loading...</p>;
      }
    return (
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

      <h2>
        <center>Leki bez recepty</center>
      </h2>
      <table className="table table-stripe">
                <thead>
                  <tr>
                    <th>Nazwa</th>
                    <th>Czy dla dzieci</th>
                    <th>Cena</th>
                    <th>Opis</th>
                    <th>Zdjecie</th>
                  </tr>
                </thead>
                <tbody>
    {this.state.lista_bez_recepty.map(c =>
                    <tr key={c.id}>
                      <td>{c.nazwa}</td>
                      <td> { String( c.czyDlaDzieci ) }</td>
                      <td>{c.cena}</td>
                      <td>{c.opis}</td>
                      <td>
                        <img className="pic__photo" src={"data:image/png;base64," + c.zdjecie} />
                      </td>
                    </tr>
                  )}
                </tbody>
              </table>
          </div>
          <div id="stopka">
          <div id="copyright">Copyright by </div>
          <div id="design"></div>
          </div>
        </div>
    );
  }

  componentDidMount() {
    this.setState({isLoading: true});
   axios.get("http://localhost:8080/api/bezrecepty")
     .then(res => {
       this.setState({ lista_bez_recepty: res.data });
     })
     .then(() => this.setState({isLoading: false}));
   }
}
export default BezRecepty;
