import React from "react";
import defaultChessboardState from "../utils/defaultChessboardState";
import squareStaticInformation from "../utils/squareStaticInformation";
import chessboardThemes from "../utils/chessboardThemes";
import Square from "./Square";
import "../styles/Board.css";

import useFetchData from "../hooks/useFetchData";

export default function Board() {

    const [chessboardState, setChessboardState] = React.useState(defaultChessboardState);
    const [theme, setTheme] = React.useState(chessboardThemes.classic);
    const [selectedOriginSquare, setSelectedOriginSquare] = React.useState(""); 

    const { data: newChessBoardState, isLoading: isLoadingNewChessBoardState, error: errorNewChessBoardState } = useFetchData("http://localhost:8080/gameId=", selectedOriginSquare);

    
    const handleClick = async (e) => {
        const clickedSquare = e.target.id;

        console.log(`Making API call "Check Valid Moves": selected origin: ${clickedSquare}`);
        console.log("API response......");
        setSelectedOriginSquare(clickedSquare);
        console.log("new Chessboard state with valid moves");
        // setChessboardState(newChessBoardState);
        console.log(newChessBoardState);
        console.log("ERROR?:", errorNewChessBoardState);

        return;
    }
    
    const SquareList = chessboardState.map( (square) => {
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
