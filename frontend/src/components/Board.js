import React from "react";
import defaultChessboardState from "../utils/defaultChessboardState";
import chessboardThemes from "../utils/chessboardThemes";
import Square from "./Square";
import "../styles/Board.css";

export default function Board() {

    const [chessboardState, setChessboardState] = React.useState(defaultChessboardState);
    const [theme, setTheme] = React.useState(chessboardThemes.classic);

    const SquareList = chessboardState.map( (square) => {
        return( 
            <Square key={square.id}
                    id={square.id}
                    theme={theme}
                    piece={square.piece} 
                    shapeFormat={square.shape}
                    isValid={square.isValid}
                    framePosition={square.centerPos}/>)
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
