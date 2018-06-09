import React, { Component } from 'react';
import axios from 'axios'

class Nfz extends Component {
  constructor(props) {
   super(props);
   this.state = {
     lista_nfz: [],
     isLoading: false
   };
 }

render() {
  const {isLoading} = this.state;

  if (isLoading) {
      return <p>Loading...</p>;
    }
  return (
    <div className="Nfz">
    <table className="table table-stripe">
              <thead>
                <tr>
                  <th>Nazwa</th>
                  <th>Miasto</th>
                </tr>
              </thead>
              <tbody>
                {this.state.lista_nfz.map(c =>
                  <tr key={c.id}>
                    <td>{c.nazwa}</td>
                    <td>{c.miasto}</td>
                  </tr>
                )}
              </tbody>
            </table>
    </div>
  );
}
componentDidMount() {
  this.setState({isLoading: true});
 axios.get("http://localhost:8080/api/nfz")
   .then(res => {
     this.setState({ lista_nfz: res.data });
   })
   .then(() => this.setState({isLoading: false}));
 }
}
export default Nfz;
