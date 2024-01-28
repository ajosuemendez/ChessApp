import "../styles/Dropdown.css";
import {useState, useEffect, useRef, useCallback } from "react";

const Dropdown = ({ label,selectedOption, options, handleSelect }) => {

  const [isOpen, setIsOpen] = useState(false);

  const dropdownRef = useRef(null);

  const handleOptionClick = (option) => {
    handleSelect(option);
    closeDropdown();
  };

  const closeDropdown = useCallback(() => {
    setIsOpen(false);
  }, [setIsOpen]);

  const toggleDropdown = () => {
    setIsOpen(!isOpen);
  };

  const handleClickOutside = useCallback((event) => {
    if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
      closeDropdown();
    }
  }, [closeDropdown]);

  useEffect(() => {
    document.addEventListener('mousedown', handleClickOutside);

    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, [handleClickOutside]);

  return (
    <div ref={dropdownRef} className="dropdown">
      <label style={{ cursor: "pointer" }} onClick={toggleDropdown}>
        {label}: {selectedOption}
      </label>
      <div className="dropdown-container">
        {isOpen && (
          <ul className="dropdown-options">
            {options.map((option) => (
              <li key={option} onClick={() => handleOptionClick(option)}>
                {option}
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
};

export default Dropdown;
