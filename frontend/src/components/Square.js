import Piece from "./Piece";
import {getSquareColor} from "../utils/getSquareColor";

export default function Square({id, theme, piece, shapeFormat, isValid, framePosition}) {

    const handleClick = (e) => {
        console.log(e.target.id);
    };

    let squareColor = getSquareColor(id) === "dark" ? theme.colors.darkSquareColor :  theme.colors.lightSquareColor;

    // Overwrite color if is a valid square
    if (isValid) {
        squareColor = theme.colors.strongSquareColor;
    } 
    
    return(
        <>
            <path onClick={handleClick} id={id} d={shapeFormat} fill={squareColor} stroke="black" strokeWidth="1.2"/>
            <Piece pieceType={piece} theme={theme.type} framePosition={framePosition} />
        </>
    );
}