import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import {App} from './App';
import { BrowserRouter} from 'react-router-dom';
import { loadStripe } from '@stripe/stripe-js';
import { Elements } from '@stripe/react-stripe-js';

const stripePromise = loadStripe('pk_test_51NhINsDzj6l4Mj7ad9zTozTUn56aTlFl15G1kfeEKsbVX4keBiirLzoScoQ3NYf18p4anKrnvFAiY4VYSCftNmEM00s0EjIShh');

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <BrowserRouter>
  <Elements stripe={stripePromise}>
  <App />
  </Elements>
  </BrowserRouter>
);


