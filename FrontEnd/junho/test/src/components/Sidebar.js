import React from 'react';
import {Link} from 'react-router-dom';
import SideNav, { Toggle, Nav, NavItem, NavIcon, NavText } from '@trendmicro/react-sidenav';
// Be sure to include styles at some point, probably during your bootstraping
import './Sidebar.css';
import home from '../image/home.png';

const Sidebar = () => (
    <SideNav onSelect={(selected) => {}}>
        <SideNav.Toggle />
        <SideNav.Nav defaultSelected="home">
            <NavItem eventKey="home">
                <NavIcon>
                    <img className="sideImage" src={home} alt="home"/>
                </NavIcon>
                <NavText>
                    홈
                </NavText>
            </NavItem>
            <NavItem eventKey="charts">
                <NavIcon>
                    <i className="fa fa-fw fa-line-chart" style={{ fontSize: '1.75em' }} />
                </NavIcon>
                <NavText>
                    <Link to="/news" style={{ marginLeft:10, color: 'inherit', textDecoration: 'inherit'}}>뉴스</Link>
                </NavText>
                <NavItem eventKey="charts/linechart">
                    <NavText>
                        최신뉴스
                    </NavText>
                </NavItem>
                <NavItem eventKey="charts/barchart">
                    <NavText>
                        선호뉴스
                    </NavText>
                </NavItem>
            </NavItem>
        </SideNav.Nav>
    </SideNav>
)

export default Sidebar;