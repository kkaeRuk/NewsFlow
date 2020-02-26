import React from 'react';
import './Header.css';
import profile from './profile.png';
import {Link} from 'react-router-dom';

const Header = () => (
    <div className="header">
        <Link to="/">NewsFlow</Link>
        <div className="button1">
            <Link to="/login">
            <button type="" name="profile" id="profile">
                <img className="small" src={profile} alt="profile"/>
            </button>
            </Link>
            <button>login</button>
        </div>
    </div>
)
export default Header;