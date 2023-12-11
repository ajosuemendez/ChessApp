
export default function Piece({key, pieceType, theme, framePosition}) {
    
    if ( pieceType === null ) {
        return <></>;
    }

    const pieceImage = process.env.PUBLIC_URL + `/images/themes/${theme}/${pieceType}-${theme}.png`;

    console.log(key);

    return <image   key={pieceType}
                    href={pieceImage}
                    alt={`Piece ${pieceType}`} 
                    width={40}
                    height={40}
                    x = {framePosition.x}
                    y = {framePosition.y}
                    style={{ pointerEvents: 'none' }}/>
}