import React from 'react';
import './Login.css';

import Kakao from './kakao_account.png';
import Naver from './naver_account.png';
import Google from './google_account.png';

const Login = () => {
    return (
        <div className="login">
            <div className="logintitle">
                Login
                <hr/>
            </div>
            
            <div className="loginSection">
                <form className="loginForm">
                    <label className="labelid">ID</label>
                    <input className="inputid" type="text" name="id"></input><br/>
                    <label className="labelpw">PW</label>
                    <input className="inputpw" type="text" name="password"></input><br/>
                    <button className="bt1">OK</button>
                </form>
                <br/><br/>
            </div>
            <div className="OAuth">
                <button><img className="oauthLogin" src={Naver} alt="naver"/></button><br/>
                <button><img className="oauthLogin" src={Kakao} alt="kakao"/></button><br/>
                <button><img className="oauthLogin" src={Google} alt="google"/></button>
            </div>
        </div>
    );
}
export default Login;