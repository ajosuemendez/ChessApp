import React from 'react';
import '../styles/Button.css';

const Button = ({ text, imageSrc, clickHandler }) => {
  return (
    <button className="soft-button" onClick={clickHandler}>
      {imageSrc && <img className="button-image" src={imageSrc} alt="Button Icon" />}
      {text}
    </button>
  );
}

export default Button;
