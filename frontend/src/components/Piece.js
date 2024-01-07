
export default function Piece({pieceType, theme, framePosition}) {
    
    if ( pieceType === null ) {
        return <></>;
    }

    const pieceImage = process.env.PUBLIC_URL + `/images/themes/${theme}/${pieceType}-${theme}.png`;
    return <image   key={pieceType}
                    href={pieceImage}
                    alt={`Piece ${pieceType}`} 
                    width={50}
                    height={50}
                    x = {framePosition.x-4}
                    y = {framePosition.y-4}
                    style={{ pointerEvents: 'none' }}/>
}