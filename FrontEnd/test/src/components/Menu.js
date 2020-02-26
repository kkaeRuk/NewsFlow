import React from 'react';
import {Link} from 'react-router-dom';
import './Menu.css';

const Menu = ({checked,onToggle}) =>{
    return (
        <div className="menu">
            <button ClassName="button" onclick={() => onToggle(checked)}>
                사이드바 접기
            </button>
            <div className={`expaned ${checked ? ' expaned' : 'collapsed'}`}>
                <div></div>
            </div>
            {
                (function() {
                    if(checked===true) return(
                        <div className="sidebar">
                            <ul>
                                <li><Link to="/">Home</Link></li>
                                <li><Link to="/about">About</Link></li>
                                <li><Link to="/about/foo">About Foo</Link></li>
                            </ul>
                            <button role="presentation" onclick={() => onToggle(checked)}>
                                사이드바 접기
                            </button>
                        </div>
                    );
                    else return(
                        <div className="sidebar collapsed">
                            <ul>
                                <li><Link to="/">H</Link></li>
                                <li><Link to="/about">A</Link></li>
                                <li><Link to="/about/foo">A.F</Link></li>
                            </ul>
                            <button role="presentation" onclick={() => onToggle(checked)}>
                                펼치기
                            </button>
                        </div>
                    );
                })()   
            }
        </div>
    )
};
export default Menu;

