import React from "react";
import { useLocation } from "react-router-dom";

import Board from "../components/Board";
import Historytable from "../components/HistoryTable";
// import defaultChessboardState from "../utils/defaultChessboardState";


export default function Game() {

    const location = useLocation();
    const gameState = location.state?.gameData || {};
    const [chessboardState, setChessboardState] = React.useState(gameState.boardState);


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


    return(
        <>
            <Board chessboardState={chessboardState} handleClick={handleClick}/>
            <Historytable moves={["e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7"]}/>
        </>
    );
}