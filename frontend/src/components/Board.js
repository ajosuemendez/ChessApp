import React from "react";
import defaultChessboardState from "../utils/defaultChessboardState";
import squareStaticInformation from "../utils/squareStaticInformation";
import chessboardThemes from "../utils/chessboardThemes";
import threePlayerMetaData from "../utils/threePlayerMetaData";
import Square from "./Square";
import "../styles/Board.css";
import PlayerLabel from "./PlayerLabel";

// Context
import { useThemeContext } from '../context/ThemeContext';

export default function Board() {
    const { theme } = useThemeContext();
    const [chessboardState, setChessboardState] = React.useState(defaultChessboardState);


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
            // if (square.id === "e11" || square.id === "e9") {square.isFromPreviousMove = true}// For testing purposes
            // if (square.id === "e11") {square.isSelectedPieceSquare = true}// For testing purposes
            return( 
                <Square key={square.id}
                        theme={theme}
                        id={square.id}
                        piece={square.piece} 
                        isValid={square.isValid}
                        isFromPreviousMove={square.isFromPreviousMove}
                        isSelectedPieceSquare={square.isSelectedPieceSquare}
                        shapeFormat={squareStaticInformation[square.id].shape}
                        framePosition={squareStaticInformation[square.id].centerPos}
                        handleClick={handleClick}/>)
        })
    }

    const playerLabelList = threePlayerMetaData.map( (player) => {
        return(
            <PlayerLabel key={player.id} label={player.label} name={player.name} id={player.id}/>
        );
    })
    
    return (
        <div className="board-container">
            <svg className="svg-board" width="1640" height="auto" viewBox="0 0 2339 1771" fill="none" xmlns="http://www.w3.org/2000/svg">
                <g id="Chessboard Frame" filter="url(#filter0_d_1_3)">
                    {SquareList}
                </g>
            </svg>
            {playerLabelList}
        </div>
    );
}
