import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import { Home, About, Login } from './pages';
import Header from './components/Header';
//import Menu from './components/Menu';
import {Link} from 'react-router-dom';
//import './App.css';
//import TestTemplate from './components/testTemplate';

class App extends Component {
  state = {isSidebarExpaned: false}

  handleToggle = (isSidebarExpaned) => {
    if(isSidebarExpaned === false)
      this.setState({isSidebarExpaned: true});
    else
      this.setState({isSidebarExpaned: false});
  };
  render(){
    const {isSidebarExpaned} = this.state;
    const {
      handleToggle
    } = this;
    return (
      <div>
        <Header/>
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

//<Menu checked={isSidebarExpaned} onToggle={handleToggle}/>