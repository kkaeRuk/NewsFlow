import React from 'react';
import './Header.css';
import profile from '../image/profile.png';
import {Link} from 'react-router-dom';

const Header = () => (
    <div className="header" >
        <Link to="/" style={{ color: 'inherit', textDecoration: 'inherit'}}>NewsFlow</Link>
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