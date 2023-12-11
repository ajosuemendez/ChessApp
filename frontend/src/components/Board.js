import React from "react";
import defaultChessboardState from "../utils/defaultChessboardState";
import chessboardThemes from "../utils/chessboardThemes";
import Square from "./Square";
import "../styles/Board.css";

import useFetchData from "../hooks/useFetchData";

export default function Board() {

    const [chessboardState, setChessboardState] = React.useState(defaultChessboardState);
    const [theme, setTheme] = React.useState(chessboardThemes.classic);
    const [selectedOriginSquare, setSelectedOriginSquare] = React.useState(""); 

    const { data: validMoves, isLoading: isLoadingValidMoves, error: errorValidMoves } = useFetchData("http://localhost:8080/gameId=", selectedOriginSquare);

    


    const handleClick = async (e) => {
        const clickedSquare = e.target.id;

        if (selectedOriginSquare === "") {
            
            console.log(`Making API call "Check Valid Moves": selected origin: ${clickedSquare}`);
            console.log("API response......");
            setSelectedOriginSquare(clickedSquare);
            console.log("valid moves", validMoves);
            console.log("Something went wrong", errorValidMoves);
            
            // if response comes without valid moves then the player has chosen a wrong piece or none.
            const responseWithoutValidMoves = false;
            if (responseWithoutValidMoves) {
                console.log("Getting new chessboard state without Valid Moves from the API");
                return;
            }

            console.log("Getting new chessboard state WITH Valid Moves from the API");
            console.log(`Setting selected origin to ${clickedSquare}`);
            setSelectedOriginSquare(clickedSquare);
            return;
        }

        console.log(`Making API call "Move Piece": selected origin: ${selectedOriginSquare} , selected destination: ${clickedSquare}`);
        console.log("API response....");

        // If getting a chessboard state with valid moves then we have clicked another piece of us
        const responseWithValidMoves = false;
        if (responseWithValidMoves) {
            console.log("Getting new chessboard state WITH valid moves from the API");
            console.log(`Setting selected origin to ${clickedSquare}`);
            selectedOriginSquare(clickedSquare);
            return;
        }
        
        // If getting a chessboard state without any valid moves then we updated the last played and now is the next players turn
        console.log("Getting new chessboard state WITH valid moves from the API");
        console.log(`Setting selected origin to ""`);
        setSelectedOriginSquare("");

        return;
    }
    
    const SquareList = chessboardState.map( (square) => {
        return( 
            <Square key={square.id}
                    id={square.id}
                    theme={theme}
                    piece={square.piece} 
                    shapeFormat={square.shape}
                    isValid={square.isValid}
                    framePosition={square.centerPos}
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
