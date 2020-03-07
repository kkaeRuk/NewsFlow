import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import { Home, About, Login } from './pages';
import Header from './components/Header';
import Sidebar from './components/Sidebar';
//import {Link} from 'react-router-dom';
//import './App.css';
//import TestTemplate from './components/testTemplate';

class App extends Component {

  render(){
    return (
      <div>
        <Header/>
        <Sidebar/>
        <Route exact path="/" component={Home}/>
        <Switch>
          <Route path="/login" component={Login}/>
          <Route path="/about" component={About}/>
          <Route path="/about/:name" component={About}/>
        </Switch>
      </div>
    );
  }
}
export default App;