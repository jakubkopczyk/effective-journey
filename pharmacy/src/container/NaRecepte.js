import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

class NaRecepte extends Component{
  constructor(props) {
    super(props);
    this.state = {
      lista_na_recepte: [],
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
              <center>Leki na receptę</center>
            </h2>
            <table className="table table-stripe">
              <thead>
                <tr>
                  <th>Nazwa</th>
                  <th>Czy dla dzieci</th>
                  <th>Cena</th>
                  <th>Procent refundacji</th>
                  <th>Opis</th>
                  <th>Zdjecie</th>
                  <th>Przepisane przez lekarza:</th>
                  <th>Przepisany oddział NFZ:</th>

                </tr>
              </thead>
              <tbody>
                {this.state.lista_na_recepte.map(c =>
                  <tr key={c.id}>
                    <td>{c.nazwa}</td>
                    <td> { String( c.czyDlaDzieci ) }</td>
                    <td>{c.cena}</td>
                    <td>{c.procentRefundacji}</td>
                    <td>{c.opis}</td>
                    <td>
                      <img className="pic__photo" src={"data:image/png;base64," + c.zdjecie} />
                    </td>
                    <td>
                      {c.lekarzByIdLekarza.imie}
                      <br/>
                      {c.lekarzByIdLekarza.nazwisko}
                      <br/>
                      {c.lekarzByIdLekarza.miasto}
                    </td>
                    <td>
                      {c.lekarzByIdLekarza.nfzByIdNfz.nazwa}
                      <br/>
                      {c.lekarzByIdLekarza.nfzByIdNfz.miasto}
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
      axios.get("http://localhost:8080/api/narecepte")
      .then(res => {
        this.setState({lista_na_recepte: res.data });
      })
      .then(() => this.setState({isLoading: false}));
    }
  }
  export default NaRecepte;
