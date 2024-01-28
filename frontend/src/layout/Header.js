import React from 'react';
import { Link, NavLink } from 'react-router-dom';
import Dropdown from '../components/Dropdown';

// Styles
import '../styles/Header.css'; // Import your header styles

// Context
import { useThemeContext } from '../context/ThemeContext';

// Static Data
const logoImage = process.env.PUBLIC_URL + `/images/logo/logo.png`;


const Header = () => {

  const { selectedOption, options, handleSelect } = useThemeContext();

  return (
    <header className="header">
      <nav className="nav">
        <Link to="/" className="logo">
            <img src={logoImage} className='logo-img'/>
            <span>TheChessNut</span>
        </Link>
        <ul className="nav-list">
          <li className="nav-item">
            <NavLink to="/">
                Home
            </NavLink>
          </li>
          <li className="nav-item">
            <NavLink to="/game" >
              Game
            </NavLink>
          </li>
          <li className="nav-item">
            <Dropdown options={options} selectedOption={selectedOption} handleSelect={handleSelect} label="Theme"/>
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
