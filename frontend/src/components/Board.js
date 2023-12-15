import React from "react";
import defaultChessboardState from "../utils/defaultChessboardState";
import squareStaticInformation from "../utils/squareStaticInformation";
import chessboardThemes from "../utils/chessboardThemes";
import Square from "./Square";
import "../styles/Board.css";

export default function Board() {

    const [chessboardState, setChessboardState] = React.useState(defaultChessboardState);
    const [theme, setTheme] = React.useState(chessboardThemes.classic);


    const fetchData = async (squareId) => {
        const response = await fetch(`http://localhost:8080/gameId=${squareId}`);
        const data = await response.json();
        setChessboardState(data);
    };

    
    const handleClick = (e) => {
        const clickedSquare = e.target.id;
        console.log(`Making API call "Check Valid Moves": selected origin: ${clickedSquare}`);
        console.log("API response......");
        fetchData(clickedSquare);
        return;
    }

    let SquareList;

    if (chessboardState !== undefined) {

        SquareList = chessboardState.map( (square) => {
            return( 
                <Square 
                        theme={theme}
                        id={square.id}
                        piece={square.piece} 
                        isValid={square.isValid}
                        shapeFormat={squareStaticInformation[square.id].shape}
                        framePosition={squareStaticInformation[square.id].centerPos}
                        handleClick={handleClick}/>)
        })
    }
    

    

    return (
        <div className="board">
        <svg width="2339" height="1771" viewBox="0 0 2339 1771" fill="none" xmlns="http://www.w3.org/2000/svg">
            <g id="Chessboard Frame" filter="url(#filter0_d_1_3)">
                {SquareList}
            </g>
        </svg>
        </div>
    );
}
