import React, { createContext, useContext } from 'react';
import chessboardThemes from "../utils/chessboardThemes";

const ThemeContext = createContext();

export const useThemeContext = () => {
  return useContext(ThemeContext);
};

export const ThemeProvider = ({ children }) => {
    const defaultTheme = Object.keys(chessboardThemes)[0];

    const [selectedOption, setSelectedOption] = React.useState(defaultTheme);
    const [options] = React.useState(Object.keys(chessboardThemes));
    const [theme, setTheme] = React.useState(chessboardThemes[selectedOption]);

    const handleSelect = (option) => {
        setSelectedOption(option);
        setTheme(chessboardThemes[option]);
    };

    // Provide options and updateOptions to the children
    const contextValue = {
        theme,
        selectedOption,
        options,
        handleSelect,
    };

    return (
        <ThemeContext.Provider value={contextValue}>
        {children}
        </ThemeContext.Provider>
    );
};
