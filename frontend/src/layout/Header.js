// Header.js
import React from 'react';
import { Link, NavLink } from 'react-router-dom';
import '../styles/Header.css'; // Import your header styles

const logoImage = process.env.PUBLIC_URL + `/images/logo/logo.png`;


const Header = () => {
  return (
    <header className="header">
      <nav className="nav">
        <Link to="/" className="logo">
            <img src={logoImage} className='logo-img'/>
            <span>TheChessNut</span>
        </Link>

        <ul className="nav-list">
          <li className="nav-item">
            <NavLink to="/" exact activeClassName="active">
                Home
            </NavLink>
          </li>
          <li className="nav-item">
            <NavLink to="/game" activeClassName="active">
              Game
            </NavLink>
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
