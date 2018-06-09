import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import apap from '../assets/apap.jpg';

const BezReceptyItem = (props) => {
const lek = props.lek;

return {
  <h2>{lek.nazwa}</h2>
  <img src="{lek.zdjecie}"  />
  <div id="tekst">
  {lek.opis}
};
}
export default BezReceptyItem;
